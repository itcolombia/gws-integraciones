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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gws.integraciones.solicitudes.salidas.configuration.ConstantsStatus;
import com.gws.integraciones.solicitudes.salidas.constants.RestConstants;
import com.gws.integraciones.solicitudes.salidas.dto.DocumentosDigitalesDto;
import com.gws.integraciones.solicitudes.salidas.service.api.DocumentosDigitalesService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.DOCUMENTOS_DIGITALES, produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentosDigitalesRestController {

	@Autowired
	private DocumentosDigitalesService service;
	
	
	@GetMapping(params = { "statusArchivos" })
	public ResponseEntity<List<Integer>> findAllByStatusArchivos(@RequestParam String statusArchivos) {
		val result = service.findAllByStatusArchivos(statusArchivos);
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

	@PutMapping(value = "/{id}", params = { "statusArchivos" })
	public ResponseEntity<?> confirmar(@PathVariable Integer id, @RequestParam String statusArchivos) {
		val s = StringUtils.defaultString(statusArchivos).toUpperCase();
		switch (s) {
		case ConstantsStatus.GENERAR_PDF:
			service.confirmarReciboDocumentosDigitales(id);
			break;
		case ConstantsStatus.ACEPTADO_REGISTO_PDF_OPL:
			service.confirmarDescargaDocumentosDigitales(id);
			break;
		default:
			return ResponseEntity.badRequest()
					.body("El estado " + s + " no e un estado valido para las operaciones de confirmacion");

		}
		return null;

	}
	
	@GetMapping(value = "/{id}/archivo")
	public ResponseEntity<byte[]> report(@PathVariable Integer id) throws IOException {
		val optional = service.findById(id);
		if(optional.isPresent()) {
			val archivo = optional.get();
			//String filePath = "E:\\Reportes\\report.pdf";
			String filePath = archivo.getRutaArchivoCompleta();
			byte[] bytes = Files.readAllBytes(Paths.get(filePath));
			return ResponseEntity.ok().header("Content-Type", "application/pdf; charset=UTF-8")
					.header("Content-Disposition", "inline; filename=\"" +archivo.getNombreArchivo()+ "\"").body(bytes);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
