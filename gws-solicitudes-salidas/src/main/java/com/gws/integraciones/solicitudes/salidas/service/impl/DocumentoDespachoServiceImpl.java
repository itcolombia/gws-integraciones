package com.gws.integraciones.solicitudes.salidas.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.solicitudes.salidas.dto.DocumentoDespachoDto;
import com.gws.integraciones.solicitudes.salidas.dto.DocumentoDespachoLineaDto;
import com.gws.integraciones.solicitudes.salidas.repository.DocumentoDespachoLineaRepository;
import com.gws.integraciones.solicitudes.salidas.repository.DocumentoDespachoRepository;
import com.gws.integraciones.solicitudes.salidas.repository.SolicitudSalidaRepository;
import com.gws.integraciones.solicitudes.salidas.service.api.DocumentoDespachoService;

import lombok.val;

@Service
public class DocumentoDespachoServiceImpl implements DocumentoDespachoService {

//	private static final String ENVIAR = "ENVIAR";
//
//	private static final String RECIBIDO = "RECIBIDO";
//
//	private static final String ACEPTADO = "ACEPTADO";
//
//	private static final String ERROR = "ERROR";
//
//	private static final String CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL = "El estado actual del registro es %s. Solo se puede %s un registro si se encuentra en estado %s";

	@Autowired
	private DocumentoDespachoRepository documentoRepository;

	@Autowired
	private DocumentoDespachoLineaRepository documentoLineRepository;

	@Autowired
	private SolicitudSalidaRepository solicitudSalidaRepository;
//
//	@Autowired
//	private ErrorIntegracionRepository erroresRepository;

	// protected String getIntegracion() {
	// return "ARTICULOS";
	// }

	protected DocumentoDespachoRepository getRepository() {
		return documentoRepository;
	}

	protected SolicitudSalidaRepository getSolicitudRepository() {
		return solicitudSalidaRepository;
	}

	// @Override
	// public List<Integer> findAllByStatus(String status) {
	// val entities = getRepository().findAllByStatus(status);
	// val result = entities.stream().map(a ->
	// a.getId()).collect(Collectors.toList());
	//
	// return (result);
	// }

	@Override
	public Optional<DocumentoDespachoDto> findById(Integer idSolicitud) {
		val op1 = getRepository().findOneByIdSolicitud(idSolicitud);
		val op2 = getSolicitudRepository().findById(idSolicitud);

		if (op1.isPresent()) {
			val documento = op1.get();
			val solicitud = op2.get();
			
			val documentoLineas =  findAllByIdDocumentoDespacho(documento.getId());

			// @formatter:off
			DocumentoDespachoDto result = DocumentoDespachoDto
					.builder()
					.id(documento.getId())
					.idSolicitud(documento.getIdSolicitud())
					.prefijoPedido(solicitud.getSeriesName())
					.numeroPedido(""+solicitud.getDocNum())
					.prefijoFactura(documento.getPrefijoFactura())
					.numeroFactura(documento.getNumeroFactura())
					.documentoLineas(documentoLineas)
					.build();
			// @formatter:on
			return Optional.of(result);
		} else {
			return Optional.empty();
		}
	}

	protected List<DocumentoDespachoLineaDto> findAllByIdDocumentoDespacho(Integer id) {

		val entities = documentoLineRepository.findAllByIdDocumentoDespacho(id);

		val result = entities.stream().map(a -> {
			// @formatter:off
				DocumentoDespachoLineaDto resultDocumentoDespachoLineas = DocumentoDespachoLineaDto
							.builder()
							.lineNum(a.getLineNum())
							.itemCode(a.getItemCode())
							.quantity(a.getQuantity())
							.build();
				// @formatter:on
			return resultDocumentoDespachoLineas;
		}).collect(Collectors.toList());
		return (result);
	}

	@Override
	public void confirmarRecibo(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmarAceptacion(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmarError(Integer id, List<ErrorIntegracionDto> errores) {
		// TODO Auto-generated method stub

	}

	// @Override
	// public List<MaterialDto> findMaterialesByFatherId(Integer fatherId) {
	// val entities = materialRepository.findAllByFatherId(fatherId);
	//
	// val result = entities.stream().map(a -> {
//			// @formatter:off
//			MaterialDto resultMaterial =  MaterialDto
//					.builder()
//					.id(a.getId())
//					.fatherId(a.getFatherId())
//					.childNum(a.getChildNum())
//					.codeId(a.getCodeId())
//					.quantity(a.getQuantity())
//					.createDate(a.getCreateDate())
//					.updateDate(a.getUpdateDate())
//					.build();
//			// @formatter:on
	// return resultMaterial;
	// }).collect(Collectors.toList());
	// return (result);
	// }
	//
	// @Override
	// public void confirmarRecibo(Integer id) {
	// val optional = getRepository().findById(id);
	// if (optional.isPresent()) {
	// val entity = optional.get();
	// if (entity.getStatus().equalsIgnoreCase(ENVIAR)) {
	// entity.setStatus(RECIBIDO);
	// entity.setStatusDate(LocalDateTime.now());
	// getRepository().saveAndFlush(entity);
	// return;
	// } else {
	// throw new
	// RuntimeException(String.format(CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
	// entity.getStatus(),
	// "CONFIRMAR EL RECIBO de ", ENVIAR));
	// }
	// } else {
	// throw new EntityNotFoundException();
	// }
	// }
	//
	// @Override
	// public void confirmarAceptacion(Integer id) {
	// val optional = getRepository().findById(id);
	// if (optional.isPresent()) {
	// val entity = optional.get();
	// if (entity.getStatus().equalsIgnoreCase(RECIBIDO)) {
	// entity.setStatus(ACEPTADO);
	// entity.setStatusDate(LocalDateTime.now());
	// getRepository().saveAndFlush(entity);
	// return;
	// } else {
	// throw new
	// RuntimeException(String.format(CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
	// entity.getStatus(),
	// "ACEPTAR", RECIBIDO));
	// }
	// } else {
	// throw new EntityNotFoundException();
	// }
	// }
	//
	// @Override
	// public void confirmarError(Integer id, List<ErrorIntegracionDto> errores) {
	// val optional = getRepository().findById(id);
	// if (optional.isPresent()) {
	// val entity = optional.get();
	// if (entity.getStatus().equalsIgnoreCase(ENVIAR) ||
	// entity.getStatus().equalsIgnoreCase(RECIBIDO)) {
	// val now = LocalDateTime.now();
	//
	// entity.setStatus(ERROR);
	// entity.setStatusDate(now);
	// getRepository().saveAndFlush(entity);
	//
	// for (ErrorIntegracionDto e : errores) {
	// val error = new ErrorIntegracion();
	//
	// error.setIntegracion(getIntegracion());
	// error.setIdExterno(e.getIdExterno());
	// error.setCodigo(e.getCodigo());
	// error.setMensaje(e.getMensaje());
	// error.setArg0(e.getArg0());
	// error.setArg1(e.getArg1());
	// error.setArg2(e.getArg2());
	// error.setArg3(e.getArg3());
	// error.setArg4(e.getArg4());
	// error.setArg5(e.getArg5());
	// error.setArg6(e.getArg6());
	// error.setArg7(e.getArg7());
	// error.setArg8(e.getArg8());
	// error.setArg9(e.getArg9());
	//
	// error.setFechaCreacion(now);
	// error.setFechaModificacion(now);
	//
	// erroresRepository.save(error);
	// }
	// erroresRepository.flush();
	// return;
	// } else {
	// throw new
	// RuntimeException(String.format(CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
	// entity.getStatus(),
	// "RECHAZAR", ENVIAR + " o " + RECIBIDO));
	// }
	// } else {
	// throw new EntityNotFoundException();
	// }
	// }

}
