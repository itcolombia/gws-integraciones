package com.gws.integraciones.solicitudes.salidas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.solicitudes.salidas.dto.CabDespachosDto;
import com.gws.integraciones.solicitudes.salidas.dto.DetDespachosDto;
import com.gws.integraciones.solicitudes.salidas.repository.CabDespachosRepository;
import com.gws.integraciones.solicitudes.salidas.repository.DetDespachosRepository;
import com.gws.integraciones.solicitudes.salidas.service.api.DespachosService;

import lombok.val;

@Service
public class DespachosServicelmpl implements DespachosService {

	@Autowired
	private CabDespachosRepository cabDespachosRepository;

	@Autowired
	private DetDespachosRepository detDespachosRepository;

	@Override
	public List<Integer> findAllByStatus(String status) {
		val entities = cabDespachosRepository.findAllByStatus(status);

		val result = entities.stream().map(a -> a.getId()).collect(Collectors.toList());

		return (result);

	}

	@Override
	public Optional<CabDespachosDto> findById(Integer id) {

		val optional = cabDespachosRepository.findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			val lineas = findDetDespachosById(id);
			// @formatter:off
			val result = CabDespachosDto
					.builder()
					.id(entity.getId())
					.tipoDocumento(entity.getTipoDocumento())
					.orden(entity.getOrden())
					.seriesName(entity.getSeriesName())
					.docNum(entity.getDocNum())
					.nit(entity.getNit())
					.razonSocial(entity.getRazonSocial())
					.direccion(entity.getDireccion())
					.codDane(entity.getCodDane())
					.docDate(entity.getDocDate())
					.feMi(entity.getFeMi())
					.feMa(entity.getFeMi())
					.horaMin(entity.getHoraMin())
					.horaMax(entity.getHoraMax())
					.comments(entity.getComments())
					.createDate(entity.getCreateDate())
					.status(entity.getStatus())
					.statusDate(entity.getStatusDate())
					.lineas(lineas)
					.build();
			// @formatter:on

			result.setLineas(lineas);
			return Optional.of(result);
		} else {

			return Optional.empty();
		}
	}

	@Override
	public void confirmarRecibido(Integer id) {
			val optional = cabDespachosRepository.findById(id);
			if (optional.isPresent()) {
				val entity = optional.get();
				if (entity.getStatus().equals("MI")) {
					entity.setStatus("PR");
					entity.setStatusDate(LocalDateTime.now());

					cabDespachosRepository.saveAndFlush(entity);
					return;
				} else {
					throw new RuntimeException("No est en en un estado valido");
				}
			} else {
				throw new RuntimeException("Not Found");
			}

	}

	@Override
	public List<DetDespachosDto> findDetDespachosById(Integer id) {
		val entities = detDespachosRepository.findAllById(id);
		val result = entities.stream().map(a -> {
			// @formatter:off
			val resultDetDespachos = DetDespachosDto
					.builder()
					.lineNum(a.getLineNum())
					.itemCode(a.getItemCode())
					.dscription(a.getDscription())
					.quantity(a.getQuantity())
					.whsCode(a.getWhsCode())
					.filler(a.getFiller())
					.dian(a.getDian())
					.licTradNum(a.getLicTradNum())
					.precio(a.getPrecio())
					.build();
			// @formatter:on
			return resultDetDespachos;
		}).collect(Collectors.toList());
		return (result);
	}

}
