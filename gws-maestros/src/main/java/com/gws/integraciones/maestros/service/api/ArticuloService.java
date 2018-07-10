package com.gws.integraciones.maestros.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.maestros.dto.ArticuloDto;
import com.gws.integraciones.maestros.dto.MaterialDto;

@Transactional(readOnly = true)
public interface ArticuloService {

	List<MaterialDto> findMaterialesByFatherId(Integer fatherId);

	Optional<ArticuloDto> findById(Integer id);

	List<Integer> findAllByStatus(String status);

	@Transactional(readOnly = false)
	void confirmarRecibido(Integer id);

}
