package com.gws.integraciones.maestros.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.domain.ErrorIntegracion;
import com.gws.integraciones.dto.ErrorIntegracionDto;
import com.gws.integraciones.maestros.dto.ArticuloDto;
import com.gws.integraciones.maestros.dto.MaterialDto;
import com.gws.integraciones.maestros.repository.ArticuloRepository;
import com.gws.integraciones.maestros.repository.MaterialeRepository;
import com.gws.integraciones.maestros.service.api.ArticuloService;
import com.gws.integraciones.repository.ErrorIntegracionRepository;

import lombok.val;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	private static final String ENVIAR = "ENVIAR";

	private static final String RECIBIDO = "RECIBIDO";

	private static final String ACEPTADO = "ACEPTADO";

	private static final String ERROR = "ERROR";

	private static final String CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL = "El estado actual del registro es %s. Solo se puede %s un registro si se encuentra en estado %s";

	@Autowired
	private ArticuloRepository articuloRepository;

	@Autowired
	private MaterialeRepository materialRepository;

	@Autowired
	private ErrorIntegracionRepository erroresRepository;


	protected String getIntegracion() {
		return "ARTICULOS";
	}
	
	protected ArticuloRepository getRepository() {
		return articuloRepository;
	}

	@Override
	public List<Integer> findAllByStatus(String status) {
		val entities = getRepository().findAllByStatus(status);
		val result = entities.stream().map(a -> a.getId()).collect(Collectors.toList());

		return (result);
	}

	@Override
	public Optional<ArticuloDto> findById(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			// @formatter:off
			ArticuloDto result = ArticuloDto
					.builder()
					.id(entity.getId())
					.itemCode(entity.getItemCode())
					.itemName(entity.getItemName())
					.treeType(entity.getTreeType())
					.createDate(entity.getCreateDate())
					.updateDate(entity.getUpdateDate())
					.status(entity.getStatus())
					.statusDate(entity.getStatusDate())
					.build();
			// @formatter:on
			return Optional.of(result);
		} else {
			return Optional.empty();
		}
	}

	@Override
	public List<MaterialDto> findMaterialesByFatherId(Integer fatherId) {
		val entities = materialRepository.findAllByFatherId(fatherId);

		val result = entities.stream().map(a -> {
			// @formatter:off
			MaterialDto resultMaterial =  MaterialDto
					.builder()
					.id(a.getId())
					.fatherId(a.getFatherId())
					.childNum(a.getChildNum())
					.codeId(a.getCodeId())
					.quantity(a.getQuantity())
					.createDate(a.getCreateDate())
					.updateDate(a.getUpdateDate())
					.build();
			// @formatter:on
			return resultMaterial;
		}).collect(Collectors.toList());
		return (result);
	}

	@Override
	public void confirmarRecibo(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase(ENVIAR)) {
				entity.setStatus(RECIBIDO);
				entity.setStatusDate(LocalDateTime.now());
				getRepository().saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException(String.format(CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL, entity.getStatus(),
						"CONFIRMAR EL RECIBO de ", ENVIAR));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void confirmarAceptacion(Integer id) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase(RECIBIDO)) {
				entity.setStatus(ACEPTADO);
				entity.setStatusDate(LocalDateTime.now());
				getRepository().saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException(String.format(CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL, entity.getStatus(),
						"ACEPTAR", RECIBIDO));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void confirmarError(Integer id, List<ErrorIntegracionDto> errores) {
		val optional = getRepository().findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equalsIgnoreCase(ENVIAR) || entity.getStatus().equalsIgnoreCase(RECIBIDO)) {
				val now = LocalDateTime.now();

				entity.setStatus(ERROR);
				entity.setStatusDate(now);
				getRepository().saveAndFlush(entity);

				for (ErrorIntegracionDto e : errores) {
					val error = new ErrorIntegracion();

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
				throw new RuntimeException(String.format(CAMBIO_ESTADO_NO_VALIDO_POR_ESTADO_ACTUAL, entity.getStatus(),
						"RECHAZAR", ENVIAR + " o " + RECIBIDO));
			}
		} else {
			throw new EntityNotFoundException();
		}
	}
}
