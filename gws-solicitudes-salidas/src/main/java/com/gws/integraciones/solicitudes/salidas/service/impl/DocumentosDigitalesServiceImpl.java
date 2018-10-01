package com.gws.integraciones.solicitudes.salidas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.solicitudes.salidas.configuration.ConstantsStatus;
import com.gws.integraciones.solicitudes.salidas.dto.DocumentosDigitalesDto;
import com.gws.integraciones.solicitudes.salidas.repository.DocumentosDigitalesRepository;
import com.gws.integraciones.solicitudes.salidas.service.api.DocumentosDigitalesService;

import lombok.val;

@Service
public class DocumentosDigitalesServiceImpl implements DocumentosDigitalesService {

	@Autowired
	private DocumentosDigitalesRepository digitalesRepository;

	protected DocumentosDigitalesRepository getRepository() {
		return digitalesRepository;
	}

	@Override
	public List<Integer> findAllByStatusArchivos(String statusArchivos) {
		val entities = getRepository().findAllByStatusArchivos(statusArchivos);
		val result = entities.stream().map(a -> a.getId()).collect(Collectors.toList());

		return (result);
	}

	@Override
	public Optional<DocumentosDigitalesDto> findById(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();

			// @formatter:off
			DocumentosDigitalesDto result = DocumentosDigitalesDto
					.builder()
					.id(entity.getId())
					.idSolicitud(entity.getIdSolicitud())
					.serieDocumentosDespacho(entity.getSerieDocumentosDespacho())
					.numeroDocumentoDespacho(entity.getNumeroDocumentoDespacho())
					.nombreArchivo(entity.getNombreArchivo())
					.build();
			// @formatter:on
			return Optional.of(result);
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void confirmarReciboDocumentosDigitales(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatusArchivos().equalsIgnoreCase(ConstantsStatus.GENERAR_PDF)) {
				entity.setStatusArchivos(ConstantsStatus.ACEPTADO_REGISTO_PDF_OPL);
				entity.setStatusDateRecibido(LocalDateTime.now());
				getRepository().saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException(String.format(ConstantsStatus.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
						entity.getStatusArchivos(), "CONFIRMAR EL RECIBO de ", ConstantsStatus.GENERAR_PDF));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void confirmarDescargaDocumentosDigitales(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatusArchivos().equalsIgnoreCase(ConstantsStatus.ACEPTADO_REGISTO_PDF_OPL)) {
				entity.setStatusArchivos(ConstantsStatus.DESCARGADO_PDF_OPL);
				entity.setStatusDateDescarga(LocalDateTime.now());
				getRepository().saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException(String.format(ConstantsStatus.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
						entity.getStatusArchivos(), "CONFIRMAR EL RECIBO de ",
						ConstantsStatus.ACEPTADO_REGISTO_PDF_OPL));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}
}
