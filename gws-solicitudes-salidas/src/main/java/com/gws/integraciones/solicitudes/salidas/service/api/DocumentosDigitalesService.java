package com.gws.integraciones.solicitudes.salidas.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.solicitudes.salidas.dto.DocumentosDigitalesDto;

@Transactional(readOnly = true)
public interface DocumentosDigitalesService {

	Optional<DocumentosDigitalesDto> findById(Integer id);
	
	List<Integer> findAllByStatus(String status);
	
	
	@Transactional(readOnly = false)
	void confirmarReciboDocumentosDigitales(Integer id);

	@Transactional(readOnly = false)
	void confirmarDescargaDocumentosDigitales(Integer id);
	
	@Transactional(readOnly = false)
	//void rechazarDescargaDocumentosDigitales(Integer id);
	void rechazarDescargaDocumentosDigitales(Integer id, List<ErrorIntegracionDto> errores);
	
}
