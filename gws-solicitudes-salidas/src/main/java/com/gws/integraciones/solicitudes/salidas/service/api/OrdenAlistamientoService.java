package com.gws.integraciones.solicitudes.salidas.service.api;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.solicitudes.salidas.dto.OrdenAlistamientoDto;



@Transactional(readOnly = true)
public interface OrdenAlistamientoService {
	
	@Transactional(readOnly = false)
	Integer recibirOrdenAlistamiento(OrdenAlistamientoDto alistamiento);
}
