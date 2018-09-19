package com.gws.integraciones.solicitudes.salidas.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.solicitudes.salidas.dto.DocumentoDespachoDto;
import com.gws.integraciones.solicitudes.salidas.dto.DocumentoDespachoLineaDto;
import com.gws.integraciones.solicitudes.salidas.repository.DocumentoDespachoLineaRepository;
import com.gws.integraciones.solicitudes.salidas.repository.DocumentoDespachoRepository;
import com.gws.integraciones.solicitudes.salidas.repository.SolicitudSalidaRepository;
import com.gws.integraciones.solicitudes.salidas.service.api.DocumentoDespachoService;

import lombok.val;

@Service
public class DocumentoDespachoServiceImpl implements DocumentoDespachoService {


	@Autowired
	private DocumentoDespachoRepository documentoRepository;

	@Autowired
	private DocumentoDespachoLineaRepository documentoLineRepository;

	@Autowired
	private SolicitudSalidaRepository solicitudSalidaRepository;


	protected DocumentoDespachoRepository getRepository() {
		return documentoRepository;
	}

	protected SolicitudSalidaRepository getSolicitudRepository() {
		return solicitudSalidaRepository;
	}

	@Override
	public Optional<DocumentoDespachoDto> findById(Integer idSolicitud) {

		val op1 = getRepository().findOneByIdSolicitud(idSolicitud);
		val op2 = getSolicitudRepository().findById(idSolicitud);

		if (op1.isPresent()) {
			val documento = op1.get();
			val solicitud = op2.get();

			val documentoLineas = findAllByIdDocumentoDespacho(documento.getId());

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
}
