package com.gws.integraciones.solicitudes.salidas.service.api;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.solicitudes.salidas.dto.DocumentoDespachoDto;

@Transactional(readOnly = true)
public interface DocumentoDespachoService {

	Optional<DocumentoDespachoDto> findById(Integer id);
}
