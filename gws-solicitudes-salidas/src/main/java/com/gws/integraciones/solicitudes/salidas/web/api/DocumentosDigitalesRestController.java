package com.gws.integraciones.solicitudes.salidas.web.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.solicitudes.salidas.configuration.ConstantsStatusArchivos;
import com.gws.integraciones.solicitudes.salidas.constants.RestConstants;
import com.gws.integraciones.solicitudes.salidas.dto.DocumentosDigitalesDto;
import com.gws.integraciones.solicitudes.salidas.service.api.DocumentosDigitalesService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.DOCUMENTOS_DIGITALES, produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentosDigitalesRestController {

	@Autowired
	private DocumentosDigitalesService service;

	@GetMapping(params = { "status" })
	public ResponseEntity<List<Integer>> findAllByStatus(@RequestParam String status) {
		val result = service.findAllByStatus(status);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DocumentosDigitalesDto> findById(@PathVariable Integer id) {
		val optional = service.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "/{id}", params = { "status" })
	public ResponseEntity<?> confirmar(@PathVariable Integer id, @RequestParam String status) {
		val s = StringUtils.defaultString(status).toUpperCase();
		switch (s) {
		case ConstantsStatusArchivos.RECIBIDO_OPL:
			service.confirmarReciboDocumentosDigitales(id);
			break;
		case ConstantsStatusArchivos.ARCHIVO_DESCARGADO_OPL:
			service.confirmarDescargaDocumentosDigitales(id);
			break;
		default:
			return ResponseEntity.badRequest()
					.body("El estado " + s + " no e un estado valido para las operaciones de confirmacion");

		}
		return null;

	}

	// ObjectMapper mapper = new ObjectMapper();
	// ObjectNode node = mapper.createObjectNode();
	// node.put("codigo", "1111");
	// node.put("mensaje",ConstantsStatus.NO_HAY_ARCHIVO);
	@GetMapping(value = "/{id}/archivo")
	public ResponseEntity<?> report(@PathVariable Integer id) throws IOException {
		val optional = service.findById(id);
		if (optional.isPresent()) {

			val archivo = optional.get();
			if (archivo.isArchivoCreado()) {
				//switch (archivo.getStatus()) {
				//case "RECIBIDO_OPL":
					//service.confirmarDescargaDocumentosDigitales(id);
					String filePath = archivo.getRutaArchivoCompleta();
					byte[] bytes = Files.readAllBytes(Paths.get(filePath));
					return ResponseEntity.ok().header("Content-Type", "application/pdf; charset=UTF-8")
							.header("Content-Disposition", "inline; filename=\"" + archivo.getNombreArchivo() + "\"")
							.body(bytes);
				//case "ARCHIVO_DESCARGADO_OPL":
				//default:
					//break;
				//}
			}
			return ResponseEntity.badRequest()
					.body(ConstantsStatusArchivos.NO_HAY_ARCHIVO + " o esa ta en un estado que no admite descaraga");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping(value = "/{id}/error", params = { "status" })
	public ResponseEntity<String> error(@PathVariable Integer id, @RequestParam String status, @RequestBody List<ErrorIntegracionDto> errores) {
		val e = StringUtils.defaultString(status).toUpperCase();
		switch (e) {
		case ConstantsStatusArchivos.ARCHIVO_RECHAZADO_OPL:
			service.rechazarDescargaDocumentosDigitales(id, errores);
			break;

		default:
			return ResponseEntity.badRequest().body("El estado " + e + " no es un estado valido para las operaciones de reporte de errores");
		}
		// AQUI NO ESTAS GUARDANDO LOS ERRORES
		return ResponseEntity.ok("");
	}
}
