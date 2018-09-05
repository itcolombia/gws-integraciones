package com.gws.integraciones.solicitudes.ordenAlistamiento.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gws.integraciones.solicitudes.ordenAlistamiento.constants.RestConstants;
import com.gws.integraciones.solicitudes.ordenAlistamiento.dto.OrdenAlistamientoDto;
import com.gws.integraciones.solicitudes.ordenAlistamiento.service.api.OrdenAlistamientoService;

import lombok.val;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = RestConstants.ORDEN_ALISTAMIENTO, produces = MediaType.APPLICATION_JSON_VALUE)

public class OrdenAlistamientoRestController {

	@Autowired
	private OrdenAlistamientoService service;

	@PostMapping()
	public ResponseEntity<Integer> alistar(@RequestBody OrdenAlistamientoDto alistamiento) {
		val id = service.recibirOrdenAlistamiento(alistamiento);
		return ResponseEntity.ok(id);
	}
}
