package com.gws.integraciones.solicitudes.salidas.client.service.api;

import java.util.List;

import com.gws.integraciones.core.web.client.service.api.LocalQueryService;
import com.gws.integraciones.solicitudes.salidas.dto.SolicitudDto;

public interface SalidasLocalService extends LocalQueryService<SolicitudDto,Integer> {

	List<Integer> getAllByStatus(String status);

	void confirmarRecibo(Integer id);
}