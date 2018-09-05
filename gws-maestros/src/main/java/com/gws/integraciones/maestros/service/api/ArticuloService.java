package com.gws.integraciones.maestros.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.maestros.dto.ArticuloDto;
import com.gws.integraciones.maestros.dto.MaterialDto;

@Transactional(readOnly = true)
public interface ArticuloService {

	List<Integer> findAllByStatus(String status);

	Optional<ArticuloDto> findById(Integer id);

	List<MaterialDto> findMaterialesByFatherId(Integer fatherId);

	@Transactional(readOnly = false)
	void confirmarRecibo(Integer id);

	@Transactional(readOnly = false)
	void confirmarAceptacion(Integer id);
	
	@Transactional(readOnly = false)
	void confirmarError(Integer id, List<ErrorIntegracionDto> errores);
}
