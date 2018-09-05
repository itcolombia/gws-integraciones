package com.gws.integraciones.solicitudes.ordenAlistamiento.service.api;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.solicitudes.ordenAlistamiento.dto.OrdenAlistamientoDto;

@Transactional(readOnly = true)

public interface OrdenAlistamientoService {
	
	@Transactional(readOnly = false)
	Integer recibirOrdenAlistamiento(OrdenAlistamientoDto alistamiento);
}
