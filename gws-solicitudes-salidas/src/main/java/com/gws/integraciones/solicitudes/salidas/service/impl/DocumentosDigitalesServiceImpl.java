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
import com.gws.integraciones.solicitudes.salidas.configuration.ConstantsStatusArchivos;
import com.gws.integraciones.solicitudes.salidas.dto.DocumentosDigitalesDto;
import com.gws.integraciones.solicitudes.salidas.repository.DocumentosDigitalesRepository;
import com.gws.integraciones.solicitudes.salidas.service.api.DocumentosDigitalesService;

import lombok.val;

@Service
public class DocumentosDigitalesServiceImpl implements DocumentosDigitalesService {

	@Autowired
	private DocumentosDigitalesRepository digitalesRepository;
	
	@Autowired
	private ErrorIntegracionRepository erroresRepository;

	protected DocumentosDigitalesRepository getRepository() {
		return digitalesRepository;
	}

	@Override
	public List<Integer> findAllByStatus(String status) {
		val entities = getRepository().findAllByStatus(status);
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
					.idTipoArchivo(entity.getIdTipoArchivo())
					.serieDocumento(entity.getSerieDocumento())
					.numeroDocumento(entity.getNumeroDocumento())
					.nombreArchivo(entity.getNombreArchivo())
					.rutaArchivoCompleta(entity.getRutaArchivoCompleta())
					.archivoCreado(entity.getArchivoCreado())
					.arg0(entity.getArg0())
					.status(entity.getStatus())
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
			if (entity.getStatus().equalsIgnoreCase(ConstantsStatusArchivos.ENVIAR)) {
				entity.setStatus(ConstantsStatusArchivos.RECIBIDO_OPL);
				entity.setStatusDateRecibido(LocalDateTime.now());
				getRepository().saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException(String.format(ConstantsStatusArchivos.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
						entity.getStatus(), "CONFIRMAR EL RECIBO de ", ConstantsStatusArchivos.ENVIAR));
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
			if (entity.getStatus().equalsIgnoreCase(ConstantsStatusArchivos.RECIBIDO_OPL)) {
				entity.setStatus(ConstantsStatusArchivos.ARCHIVO_DESCARGADO_OPL);
				entity.setStatusDateDescarga(LocalDateTime.now());
				getRepository().saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException(String.format(ConstantsStatusArchivos.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL,
						entity.getStatus(), "CONFIRMAR EL RECIBO de ", ConstantsStatusArchivos.RECIBIDO_OPL));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void rechazarDescargaDocumentosDigitales(Integer id, List<ErrorIntegracionDto> errores) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase(ConstantsStatusArchivos.ENVIAR)
					|| entity.getStatus().equalsIgnoreCase(ConstantsStatusArchivos.RECIBIDO_OPL)) {
				val now = LocalDateTime.now();
				entity.setStatus(ConstantsStatusArchivos.ARCHIVO_RECHAZADO_OPL);
				getRepository().saveAndFlush(entity);
				
				for(ErrorIntegracionDto e : errores) {
					val error = new ErrorIntegracion();
					error.setIntegracion("DocumentoDigital");
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
			}else {
				throw new RuntimeException(
						String.format(ConstantsStatusArchivos.CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL, entity.getStatus(),
								"RECHAZADO_OPL", ConstantsStatusArchivos.ENVIAR + " o " + ConstantsStatusArchivos.RECIBIDO_OPL));
			}
		}else {
			throw new EntityNotFoundException();
		}

	}
}
