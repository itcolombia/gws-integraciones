package com.gws.integraciones.solicitudes.ordenAlistamiento.client.service.api;

import java.util.List;

import com.gws.integraciones.core.web.client.service.api.LocalQueryService;
import com.gws.integraciones.solicitudes.ordenAlistamiento.dto.OrdenAlistamientoDto;

public interface OrdenAlistamientoLocalService extends LocalQueryService<OrdenAlistamientoDto,Integer> {

	List<Integer> getAllByStatus(String status);

	void confirmarRecibo(Integer id);
}