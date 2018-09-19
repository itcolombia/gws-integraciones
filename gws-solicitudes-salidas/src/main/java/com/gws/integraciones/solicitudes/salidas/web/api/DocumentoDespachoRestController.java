package com.gws.integraciones.solicitudes.salidas.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gws.integraciones.solicitudes.salidas.constants.RestConstants;
import com.gws.integraciones.solicitudes.salidas.dto.DocumentoDespachoDto;
import com.gws.integraciones.solicitudes.salidas.service.api.DocumentoDespachoService;

import lombok.val;

@RestController
@RequestMapping(value = RestConstants.DOCUMENTOS_DESPACHO, produces = MediaType.APPLICATION_JSON_VALUE)

public class DocumentoDespachoRestController {

	@Autowired
	private DocumentoDespachoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<DocumentoDespachoDto> findById(@PathVariable Integer id) {
		val optional = service.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
