package com.gws.integraciones.solicitudes.salidas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.domain.ErrorIntegracion;
import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.repository.ErrorIntegracionRepository;
import com.gws.integraciones.repository.TipoServicioRepository;
import com.gws.integraciones.solicitudes.salidas.configuration.ConstantsStatus;
import com.gws.integraciones.solicitudes.salidas.domain.ConfirmacionDespachoMercacia;
import com.gws.integraciones.solicitudes.salidas.dto.ConfirmacionDespachoMercanciaDto;
import com.gws.integraciones.solicitudes.salidas.dto.SolicitudDto;
import com.gws.integraciones.solicitudes.salidas.dto.SolicitudLineaDto;
import com.gws.integraciones.solicitudes.salidas.repository.ConfirmacionDespachoMercanciaRepository;
import com.gws.integraciones.solicitudes.salidas.repository.SolicitudSalidaLineaRepository;
import com.gws.integraciones.solicitudes.salidas.repository.SolicitudSalidaRepository;
import com.gws.integraciones.solicitudes.salidas.service.api.SolicitudDespachoService;

import lombok.val;

@Service
public class SolicitudDespachoServicelmpl implements SolicitudDespachoService {

	@Autowired
	private SolicitudSalidaRepository solicitudesRepository;

	@Autowired
	private SolicitudSalidaLineaRepository solicitudesLineaRepository;

	@Autowired
	private ErrorIntegracionRepository erroresRepository;
	
	@Autowired
	private ConfirmacionDespachoMercanciaRepository despachoMercanciaRepository;
	
	@Autowired
	private TipoServicioRepository tipoServiciosRepository;

	protected String getIntegracion() {
		return "DESPACHOS";
	}

	protected TipoServicioRepository getTipoServiciosRepository() {
		return tipoServiciosRepository;
	};
	
	protected SolicitudSalidaRepository getRepository() {
		return solicitudesRepository;
	}

	@Override
	public List<Integer> findAllByStatus(String status) {
		val entities = getRepository().findAllByStatus(status);
		val result = entities.stream().map(a -> a.getId()).collect(Collectors.toList());

		return (result);
	}

	@Override
	public Optional<SolicitudDto> findById(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			val optional2 = getTipoServiciosRepository().findById(entity.getIdTipoServicio());
			val entity2 = optional2.get();
			val lineas = findSolicitudesLineaById(id);
			// @formatter:off
			SolicitudDto result = SolicitudDto
					.builder()
					.id(entity.getId())
//					.docEntry(entity.getDocEntry())
//					.objType(entity.getObjType())
					.tipoServicio(entity2.getTipoServicio())
					.idTipoServicio(entity.getIdTipoServicio())
					.codCliente(entity.getCodCliente())
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
//					.numAtCard(entity.getNumAtCard())
					.groupName(entity.getGroupName())
					.shipToCode(entity.getShipToCode())
					.status(entity.getStatus())
//					.statusDate(entity.getStatusDate())
					.lineas(lineas)
					.build();
			// @formatter:on
			return Optional.of(result);
		} else {
			return Optional.empty();
		}
	}

	protected List<SolicitudLineaDto> findSolicitudesLineaById(Integer id) {

		val entities = solicitudesLineaRepository.findAllByIdSolicitud(id);

		val result = entities.stream().filter(a -> a.getQuantityAsignada() != null && a.getQuantityAsignada() > 0)
				.map(a -> {
				// @formatter:off
					SolicitudLineaDto resultSolicitudesLineas = SolicitudLineaDto
								.builder()
								.id(a.getId())
								.idSolicitud(a.getIdSolicitud())
								.lineNum(a.getLineNum())
								.itemCode(a.getItemCode())
								.dscription(a.getDscription())
								.quantity(a.getQuantity())
								.quantityAsignada(a.getQuantityAsignada())
								.quantityNoAsignada(a.getQuantityNoAsignada())
								.whsCode(a.getWhsCode())
								.predistribucion(a.getPredistribucion())
								.build();
					// @formatter:on
					return resultSolicitudesLineas;
				}).collect(Collectors.toList());
		return (result);
	}

	@Override
	public void confirmarReciboDeSolicitudPorOpl(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase(ConstantsStatus.ENVIAR)) {
				entity.setStatus(ConstantsStatus.RECIBIDA_OPL);
				entity.setStatusDateRecibida(LocalDateTime.now());
				getRepository().saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException(String.format(ConstantsStatus.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
						entity.getStatus(), "CONFIRMAR EL RECIBO de ", ConstantsStatus.ENVIAR));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void confirmarAceptacionDeSolicitudPorOpl(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase(ConstantsStatus.RECIBIDA_OPL)) {
				entity.setStatus(ConstantsStatus.ACEPTADA_OPL);
				entity.setStatusDateAceptada(LocalDateTime.now());
				getRepository().saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException(String.format(ConstantsStatus.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
						entity.getStatus(), "ACEPTADA_OPL", ConstantsStatus.RECIBIDA_OPL));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void confirmarSolicitudEnStagePorOpl(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val enStage = optional.get();
			if (enStage.getStatus().equalsIgnoreCase(ConstantsStatus.ACEPTADA_OPL)) {
				enStage.setStatus(ConstantsStatus.ALISTADA_OPL);
				enStage.setStatusDateAlistada(LocalDateTime.now());
				getRepository().saveAndFlush(enStage);
				return;
			} else {
				throw new RuntimeException(String.format(ConstantsStatus.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
						enStage.getStatus(), "ACEPTADA_OPL", ConstantsStatus.ALISTADA_OPL));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void registraRechazoDeSolicitudPorOpl(Integer id, List<ErrorIntegracionDto> errores) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase(ConstantsStatus.ENVIAR)
					|| entity.getStatus().equalsIgnoreCase(ConstantsStatus.RECIBIDA_OPL)) {
				val now = LocalDateTime.now();
				entity.setStatus(ConstantsStatus.RECHAZADA_OPL);
				entity.setStatusDateRechazada(now);
				getRepository().saveAndFlush(entity);

				for (ErrorIntegracionDto e : errores) {
					val error = new ErrorIntegracion();
					error.setIdSolicitud(entity.getId());
					error.setIntegracion(getIntegracion());
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
					error.setFechaCreacion(now);
					error.setFechaModificacion(now);

					erroresRepository.save(error);
				}
				erroresRepository.flush();
				return;
			} else {
				throw new RuntimeException(
						String.format(ConstantsStatus.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL, entity.getStatus(),
								"RECHAZADA_OPL", ConstantsStatus.ENVIAR + " o " + ConstantsStatus.RECIBIDA_OPL));
			}
		} else {
			
		}
	}

	@Override
	public void confirmarReciboDelDocumentoDespachoPorOpl(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase(ConstantsStatus.DOC_CREADO_SAP)) {
				entity.setStatus(ConstantsStatus.DOC_RECIBIDO_OPL);
//				entity.setStatusDate(LocalDateTime.now());
				getRepository().saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException(
						String.format(ConstantsStatus.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL, entity.getStatus()));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void registrarConfirmacionDespachoMercancia(Integer id,List<ConfirmacionDespachoMercanciaDto> confDespacho) {
		val optional = getRepository().findById(id);
		if(optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase(ConstantsStatus.DOC_RECIBIDO_OPL)) {
				val now = LocalDateTime.now();
				entity.setStatus(ConstantsStatus.DESPACHADO_OPL);
				entity.setDateDespacho(now);
				getRepository().saveAndFlush(entity);
				for(ConfirmacionDespachoMercanciaDto e : confDespacho) {
					val confirmDespa = new ConfirmacionDespachoMercacia();
					confirmDespa.setIdSolicitud(entity.getId());
					confirmDespa.setIdOrdenAlistamiento(e.getIdOrdenAlistamiento());
					confirmDespa.setPlacasVehiculo(e.getPlacasVehiculo());
					confirmDespa.setRemesa(e.getRemesa());
					confirmDespa.setTransportadora(e.getTransportadora());
					confirmDespa.setNovedades(e.getNovedades());
					confirmDespa.setItemCode(e.getItemCode());
					confirmDespa.setLineNum(e.getLineNum());
					confirmDespa.setCantidadDespachada(e.getCantidadDespachada());
					confirmDespa.setCantidadNoDespachada(e.getCantidadNoDespachada());
					confirmDespa.setDespachado(e.getDespachado());
					confirmDespa.setFechaRecibida(now);
					confirmDespa.setFechaDespacho(now);
					confirmDespa.setEstadoDespacho(e.getEstadoDespacho());;
					
					despachoMercanciaRepository.save(confirmDespa);
				}
				despachoMercanciaRepository.flush();
				return;
			}else {
				throw new RuntimeException(String.format(ConstantsStatus.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,entity.getStatus(),
						"DESPACHADO_OPL",ConstantsStatus.DOC_RECIBIDO_OPL));
			}
		}else {
			
		}
		
	}
}
