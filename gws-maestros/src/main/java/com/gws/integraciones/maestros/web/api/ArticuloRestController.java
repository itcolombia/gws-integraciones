package com.gws.integraciones.maestros.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.maestros.constants.RestConstants;
import com.gws.integraciones.maestros.dto.ArticuloDto;
import com.gws.integraciones.maestros.dto.MaterialDto;
import com.gws.integraciones.maestros.service.api.ArticuloService;

import lombok.val;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = RestConstants.articulos, produces = MediaType.APPLICATION_JSON_VALUE)
public class ArticuloRestController {

	@Autowired
	private ArticuloService service;

	@GetMapping(params = { "status" })
	public ResponseEntity<List<Integer>> finByStatus(@RequestParam String status) {

		val result = service.findAllByStatus(status);

		return ResponseEntity.ok(result);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ArticuloDto> findById(@PathVariable Integer id) {

		val optional = service.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.notFound().build();

		}
	}

	@GetMapping(value = "/{fatherId}/materiales")
	public ResponseEntity<List<MaterialDto>> findMaterialesByFatherId(@PathVariable Integer fatherId) {

		val result = service.findMaterialesByFatherId(fatherId);

		return ResponseEntity.ok(result);
	}

	@PutMapping(value = "/{id}", params = {"status=RECIBIDO"})
	public ResponseEntity<String> confirmar(@PathVariable Integer id) {
		service.confirmarRecibo(id);
		return ResponseEntity.ok("");
	}
	
	@PutMapping(value = "/{id}", params = { "status=ACEPTADO" })
	public ResponseEntity<String> procesado(@PathVariable Integer id) {
		service.confirmarAceptacion(id);
		return ResponseEntity.ok("");
	}

	@PutMapping(value = "/{id}", params = { "status=ERROR" })
	public ResponseEntity<String> error(@PathVariable Integer id, @RequestBody List<ErrorIntegracionDto> errores) {
		service.confirmarError(id, errores);
		return ResponseEntity.ok("");
	}

	
}
