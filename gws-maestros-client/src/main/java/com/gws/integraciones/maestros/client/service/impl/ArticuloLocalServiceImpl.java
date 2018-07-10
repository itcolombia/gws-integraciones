package com.gws.integraciones.maestros.client.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.core.web.client.service.impl.LocalQueryServiceImpl;
import com.gws.integraciones.maestros.client.components.MaestrosRestProperties;
import com.gws.integraciones.maestros.client.service.api.ArticuloLocalService;
import com.gws.integraciones.maestros.constants.RestConstants;
import com.gws.integraciones.maestros.dto.ArticuloDto;
import com.gws.integraciones.maestros.dto.MaterialDto;

import lombok.val;

@Service
public class ArticuloLocalServiceImpl extends LocalQueryServiceImpl<ArticuloDto, Integer>
		implements ArticuloLocalService {

	@Autowired
	private MaestrosRestProperties properties;

	protected MaestrosRestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.articulos;
	}

	@Override
	protected Class<ArticuloDto> getResponseType() {
		return ArticuloDto.class;
	}

	@Override
	protected Class<ArticuloDto[]> getArrayReponseType() {
		return ArticuloDto[].class;
	}

	@Override
	public List<Integer> getAllByStatus(String status) {
		val query = "?status={status}";
		val response = getRestClient().getAllQuery(getResourcePath(), query, Integer[].class, status);
		val result = Arrays.asList(response.getBody());
		return result;
	}

	@Override
	public List<MaterialDto> getMaterialesByFatherId(Integer fatherId) {
		val query = RestConstants.materiales;
		val response = getRestClient().getAllQuery(getResourcePath(), query, MaterialDto[].class, fatherId);
		val result = Arrays.asList(response.getBody());
		return result;
	}

	@Override
	public void confirmarRecibido(Integer id) {
		getRestClient().put(getResourcePath(), "", Object.class, id);
	}

}