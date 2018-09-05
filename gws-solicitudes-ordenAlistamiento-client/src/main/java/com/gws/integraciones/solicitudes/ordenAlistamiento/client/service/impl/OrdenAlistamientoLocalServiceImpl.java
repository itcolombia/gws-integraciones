package com.gws.integraciones.solicitudes.ordenAlistamiento.client.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.core.web.client.configuration.RestProperties;
import com.gws.integraciones.core.web.client.service.impl.LocalQueryServiceImpl;
import com.gws.integraciones.solicitudes.ordenAlistamiento.client.components.SalidasRestProperties;
import com.gws.integraciones.solicitudes.ordenAlistamiento.client.service.api.OrdenAlistamientoLocalService;
import com.gws.integraciones.solicitudes.ordenAlistamiento.constants.RestConstants;
import com.gws.integraciones.solicitudes.ordenAlistamiento.dto.OrdenAlistamientoDto;

import lombok.val;

@Service
public class OrdenAlistamientoLocalServiceImpl extends LocalQueryServiceImpl<OrdenAlistamientoDto, Integer>
		implements OrdenAlistamientoLocalService {

	@Autowired
	private SalidasRestProperties properties;

	protected RestProperties getProperties() {
		return properties;
	}

	@Override
	protected String getResourceName() {
		return RestConstants.ORDEN_ALISTAMIENTO;
	}

	@Override
	protected Class<OrdenAlistamientoDto> getResponseType() {
		return OrdenAlistamientoDto.class;
	}

	@Override
	protected Class<OrdenAlistamientoDto[]> getArrayReponseType() {
		return OrdenAlistamientoDto[].class;
	}

	@Override
	public List<Integer> getAllByStatus(String status) {
		val query = "?status={status}";
		val response = getRestClient().getAllQuery(getResourcePath(), query, Integer[].class, status);
		val result = Arrays.asList(response.getBody());
		return result;
	}

	@Override
	public void confirmarRecibo(Integer id) {
		getRestClient().put(getResourcePath(), "", Object.class, id);
	}

}