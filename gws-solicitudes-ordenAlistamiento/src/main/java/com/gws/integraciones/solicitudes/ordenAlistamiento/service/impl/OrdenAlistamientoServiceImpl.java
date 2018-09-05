package com.gws.integraciones.solicitudes.ordenAlistamiento.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.solicitudes.ordenAlistamiento.domain.OrdenAlistamiento;
import com.gws.integraciones.solicitudes.ordenAlistamiento.domain.OrdenAlistamientoLinea;
import com.gws.integraciones.solicitudes.ordenAlistamiento.domain.OrdenAlistamientoNovedades;
import com.gws.integraciones.solicitudes.ordenAlistamiento.dto.OrdenAlistamientoDto;
import com.gws.integraciones.solicitudes.ordenAlistamiento.repository.OrdenAlistamientoLineaRepository;
import com.gws.integraciones.solicitudes.ordenAlistamiento.repository.OrdenAlistamientoNovedadesRepository;
import com.gws.integraciones.solicitudes.ordenAlistamiento.repository.OrdenAlistamientoRepository;
import com.gws.integraciones.solicitudes.ordenAlistamiento.service.api.OrdenAlistamientoService;

import lombok.val;

@Service
public class OrdenAlistamientoServiceImpl implements OrdenAlistamientoService {

	@Autowired
	private OrdenAlistamientoRepository alistamientoRepository;

	@Autowired
	private OrdenAlistamientoLineaRepository alistamientoLineaRepository;

	@Autowired
	private OrdenAlistamientoNovedadesRepository alistamientoNovedadesRepository;

	@Override
	public Integer recibirOrdenAlistamiento(OrdenAlistamientoDto alistamiento) {

		val entity = new OrdenAlistamiento();

		val now = LocalDateTime.now();

		entity.setIdSolicitud(alistamiento.getIdSolicitud());
		entity.setNumeroOrdenAlistamiento(alistamiento.getNumeroOrdenAlistamiento());
		entity.setTipoOrden(alistamiento.getTipoOrden());
		entity.setFechaHoraOrden(now);
		entity.setFechaTransaccionOrden(now);

		val result = alistamientoRepository.save(entity);

		if (alistamiento.getAlistamientoLineas() != null) {
			for (val lineaDto : alistamiento.getAlistamientoLineas()) {
				val linea = new OrdenAlistamientoLinea();
				linea.setIdOrdenAlistamiento(result.getId());
				linea.setLineNum(lineaDto.getLineNum());
				linea.setSubLineNum(lineaDto.getSubLineNum());
				linea.setItemCode(lineaDto.getItemCode());
				linea.setWhsCode(lineaDto.getWhsCode());
				linea.setCantDespachada(lineaDto.getCantDespachada());
				linea.setCantNoDespachada(lineaDto.getCantNoDespachada());
				linea.setEstadoOpl(lineaDto.getEstadoOpl());
				linea.setBodegaOpl(lineaDto.getBodegaOpl());

				val hijo = alistamientoLineaRepository.save(linea);
				if (lineaDto.getAlistamientoNovedades() != null) {

					for (val lineaNovedades : lineaDto.getAlistamientoNovedades()) {
						val novedad = new OrdenAlistamientoNovedades();

						novedad.setIdAlistamientoLinea(hijo.getId());
						novedad.setCantidad(lineaNovedades.getCantidad());
						novedad.setCausalNoDespacho(lineaNovedades.getCausalNoDespacho());

						alistamientoNovedadesRepository.save(novedad);
					}
				}

			}
		}

		return result.getId();
	}
}
