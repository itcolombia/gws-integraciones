package com.gws.integraciones.solicitudes.salidas.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.solicitudes.salidas.dto.SolicitudDto;

@Transactional(readOnly = true)
public interface SolicitudSalidaService {

	Optional<SolicitudDto> findById(Integer id);

	List<Integer> findAllByStatus(String status);

	// List<DetDespachosDto> findDetDespachosById(Integer id);

	// Optional<CabDespachosDto> findById(Integer id);

	// List<Integer> findAllByStatus(String status);

	@Transactional(readOnly = false)
	void confirmarRecibo(Integer id);

}