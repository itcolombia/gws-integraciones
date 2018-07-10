package com.gws.integraciones.maestros.client.service.api;

import java.util.List;

import com.gws.integraciones.core.web.client.service.api.LocalQueryService;
import com.gws.integraciones.maestros.dto.ArticuloDto;
import com.gws.integraciones.maestros.dto.MaterialDto;

public interface ArticuloLocalService extends LocalQueryService<ArticuloDto,Integer> {

	List<Integer> getAllByStatus(String status);

	List<MaterialDto> getMaterialesByFatherId(Integer fatherId);

	void confirmarRecibido(Integer id);
}