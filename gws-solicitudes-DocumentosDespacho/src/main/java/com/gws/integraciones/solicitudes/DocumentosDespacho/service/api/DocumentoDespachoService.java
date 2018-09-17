package com.gws.integraciones.solicitudes.DocumentosDespacho.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.solicitudes.DocumentosDespacho.dto.DocumentoDespachoDto;

@Transactional(readOnly = true)
public interface DocumentoDespachoService {

	Optional<DocumentoDespachoDto> findById(Integer id); 
	
	@Transactional(readOnly = false)
	void confirmarRecibo(Integer id);
	void confirmarAceptacion(Integer id);

	@Transactional(readOnly = false)
	void confirmarError(Integer id, List<ErrorIntegracionDto> errores);
}
