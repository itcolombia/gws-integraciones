package com.gws.integraciones.solicitudes.salidas.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.solicitudes.salidas.dto.DocumentosDigitalesDto;

@Transactional(readOnly = true)
public interface DocumentosDigitalesService {

	Optional<DocumentosDigitalesDto> findById(Integer id);
	
	List<Integer> findAllByStatusArchivos(String statusArchivos);
	
	@Transactional(readOnly = false)
	void confirmarReciboDocumentosDigitales(Integer id);

	@Transactional(readOnly = false)
	void confirmarDescargaDocumentosDigitales(Integer id);

}
