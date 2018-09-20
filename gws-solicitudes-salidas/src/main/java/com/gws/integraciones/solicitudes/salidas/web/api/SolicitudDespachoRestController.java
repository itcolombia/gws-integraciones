package com.gws.integraciones.solicitudes.salidas.web.api;

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
import com.gws.integraciones.solicitudes.salidas.configuration.ConstantsStatus;
import com.gws.integraciones.solicitudes.salidas.constants.RestConstants;
import com.gws.integraciones.solicitudes.salidas.dto.SolicitudDto;
import com.gws.integraciones.solicitudes.salidas.service.api.SolicitudDespachoService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.SOLICITUDES_SALIDAS, produces = MediaType.APPLICATION_JSON_VALUE)
public class SolicitudDespachoRestController {

	@Autowired
	private SolicitudDespachoService service;

	@GetMapping(params = { "status" })
	public ResponseEntity<List<Integer>> findByStatus(@RequestParam String status) {

		val result = service.findAllByStatus(status);

		return ResponseEntity.ok(result);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SolicitudDto> findById(@PathVariable Integer id) {
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
		case ConstantsStatus.RECIBIDA_OPL:
			service.confirmarReciboDeSolicitudPorOpl(id);
			break;
		case ConstantsStatus.ACEPTADA_OPL:
			service.confirmarAceptacionDeSolicitudPorOpl(id);
			break;
		case ConstantsStatus.ALISTADA_OPL:
			service.confirmarSolicitudEnStagePorOpl(id);
			break;
		case ConstantsStatus.DOC_RECIBIDO_OPL:
			service.confirmarReciboDelDocumentoDespachoPorOpl(id);
			break;
		default:
			return ResponseEntity.badRequest().body("El estado " + s + " no es un estado valido");
		}

		return ResponseEntity.ok("");
	}
	
	@PutMapping(value = "/{id}", params = { "status="+ConstantsStatus.RECHAZADA_OPL })
	public ResponseEntity<String> error(@PathVariable Integer id, @RequestParam String status, @RequestBody List<ErrorIntegracionDto> errores) {
		service.registraRechazoDeSolicitudPorOpl(id, errores);
		// AQUI NO ESTAS GUARDANDO LOS ERRORES
		return ResponseEntity.ok("");
	}
}
