package com.gws.integraciones.solicitudes.salidas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.domain.ErrorIntegracion;
import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.repository.ErrorIntegracionRepository;
import com.gws.integraciones.solicitudes.salidas.dto.SolicitudDto;
import com.gws.integraciones.solicitudes.salidas.dto.SolicitudLineaDto;
import com.gws.integraciones.solicitudes.salidas.repository.SolicitudSalidaLineaRepository;
import com.gws.integraciones.solicitudes.salidas.repository.SolicitudSalidaRepository;
import com.gws.integraciones.solicitudes.salidas.service.api.SolicitudSalidaService;

import lombok.val;

@Service
public class SolicitudSalidaServicelmpl implements SolicitudSalidaService {

	@Autowired
	private SolicitudSalidaRepository solicitudesRepository;

	@Autowired
	private SolicitudSalidaLineaRepository solicitudesLineaRepository;

	@Autowired
	private ErrorIntegracionRepository erroresRepository;

	@Override
	public List<Integer> findAllByStatus(String status) {
		val entities = solicitudesRepository.findAllByStatus(status);
		val result = entities.stream().map(a -> a.getId()).collect(Collectors.toList());
		return (result);
	}

	@Override
	public Optional<SolicitudDto> findById(Integer id) {
		val optional = solicitudesRepository.findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			val lineas = findSolicitudesLineaById(id);
			// @formatter:off
			SolicitudDto result = SolicitudDto
					.builder()
					.id(entity.getId())
					.codCliente(entity.getCodCliente())
					.tipoServicio(entity.getTipoServicio())
					.seriesName(entity.getSeriesName())
					.docNum(entity.getDocNum())
					.direccion(entity.getDireccion())
					.codDane(entity.getCodDane())
					.nit(entity.getNit())
					.razonSocial(entity.getRazonSocial())
					.feMi(entity.getFeMi())
					.feMa(entity.getFeMa())
					.hoMi(entity.getHoMi())
					.hoMa(entity.getHoMa())
					.numAtCard(entity.getNumAtCard())
					.groupName(entity.getGroupName())
					.shipToCode(entity.getShipToCode())
					.address2(entity.getAddress2())
					.status(entity.getStatus())
					.statusDate(entity.getStatusDate())
					.lineas(lineas)
					.build();
			// @formatter:on
			return Optional.of(result);
		} else {

			return Optional.empty();
		}
	}

	@Override
	public void confirmarRecibo(Integer id) {
		val optional = solicitudesRepository.findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase("MIGRADO")) {
				entity.setStatus("RECIBIDO");
				entity.setStatusDate(LocalDateTime.now());
				solicitudesRepository.saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException("No est en en un estado valido");
			}
		} else {
			throw new RuntimeException("Not Found");
		}
	}

	@Override
	public void confirmarError(Integer id, List<ErrorIntegracionDto> errores) {
		val optional = solicitudesRepository.findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase("MIGRADO") || entity.getStatus().equalsIgnoreCase("RECIBIDO")) {
				entity.setStatus("ERROR");
				entity.setStatusDate(LocalDateTime.now());
				solicitudesRepository.saveAndFlush(entity);

				val now = LocalDateTime.now();
				for (ErrorIntegracionDto e : errores) {
					val error = new ErrorIntegracion();

					error.setIntegracion(e.getIntegracion());
					error.setIdExterno(e.getIdExterno());
					error.setCodigo(e.getCodigo());
					error.setMensaje(e.getMensaje());
					error.setArg0(e.getArg0());
					error.setArg1(e.getArg1());
					error.setArg2(e.getArg2());
					error.setArg3(e.getArg3());
					error.setArg4(e.getArg4());
					error.setArg5(e.getArg5());
					error.setArg6(e.getArg6());
					error.setArg7(e.getArg7());
					error.setArg8(e.getArg8());
					error.setArg9(e.getArg9());
					error.setVersion(0);
					error.setFechaCreacion(now);
					error.setFechaModificacion(now);
					
					erroresRepository.save(error);
				}
				erroresRepository.flush();
				return;
			} else {
				throw new RuntimeException("Not Found");
			}
		}
	}

	protected List<SolicitudLineaDto> findSolicitudesLineaById(Integer id) {
		val entities = solicitudesLineaRepository.findAllByIdSolicitud(id);
		val result = entities.stream().map(a -> {
			// @formatter:off
			SolicitudLineaDto resultSolicitudesLineas = SolicitudLineaDto
					.builder()
					.id(a.getId())
					.idSolicitud(a.getIdSolicitud())
					.lineNum(a.getLineNum())
					.itemCode(a.getItemCode())
					.dscription(a.getDscription())
					.quantity(a.getQuantity())
					.whsCode(a.getWhsCode())
					.filler(a.getFiller())
					.predistribucion(a.getPredistribucion())
					.build();
			// @formatter:on
			return resultSolicitudesLineas;
		}).collect(Collectors.toList());
		return (result);
	}
}
