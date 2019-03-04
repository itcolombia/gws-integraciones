package com.gws.integraciones.solicitudes.salidas.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.solicitudes.salidas.dto.ConfirmacionDespachoMercanciaDto;
import com.gws.integraciones.solicitudes.salidas.dto.SolicitudDto;

@Transactional(readOnly = true)
public interface SolicitudDespachoService {

	Optional<SolicitudDto> findById(Integer id);

	List<Integer> findAllByStatus(String status);

	@Transactional(readOnly = false)
	void confirmarReciboDeSolicitudPorOpl(Integer id);

	void confirmarAceptacionDeSolicitudPorOpl(Integer id);

	@Transactional(readOnly = false)
	void registraRechazoDeSolicitudPorOpl(Integer id, List<ErrorIntegracionDto> errores);

	@Transactional(readOnly = false)
	void confirmarSolicitudEnStagePorOpl(Integer id);

	@Transactional(readOnly = false)
	void confirmarReciboDelDocumentoDespachoPorOpl(Integer id);
	
	@Transactional(readOnly = false)
	void registrarConfirmacionDespachoMercancia(Integer id, List<ConfirmacionDespachoMercanciaDto> confDespacho);
}
