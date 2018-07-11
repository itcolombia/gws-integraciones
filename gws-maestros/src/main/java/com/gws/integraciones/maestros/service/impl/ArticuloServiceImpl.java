package com.gws.integraciones.maestros.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gws.integraciones.maestros.dto.ArticuloDto;
import com.gws.integraciones.maestros.dto.MaterialDto;
import com.gws.integraciones.maestros.repository.ArticuloRepository;
import com.gws.integraciones.maestros.repository.MaterialeRepository;
import com.gws.integraciones.maestros.service.api.ArticuloService;

import antlr.StringUtils;
import lombok.val;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	private ArticuloRepository articuloRepository;

	@Autowired
	private MaterialeRepository materialRepository;

	@Override
	public List<Integer> findAllByStatus(String status) {

		val entities = articuloRepository.findAllByStatus(status);
		val result = entities.stream().map(a -> a.getId()).collect(Collectors.toList());

		return (result);

	}

	@Override
	public Optional<ArticuloDto> findById(Integer id) {
		val optional = articuloRepository.findById(id);
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
	public void confirmarRecibido(Integer id) {
		val optional = articuloRepository.findById(id);
		if (optional.isPresent()) {
			val entity = optional.get();
			if (entity.getStatus().equals("MI")) {
				entity.setStatus("PR");
				entity.setStatusDate(LocalDateTime.now());

				articuloRepository.saveAndFlush(entity);
				return;
			} else {
				throw new RuntimeException("No est en en un estado valido");
			}
		} else {
			throw new RuntimeException("Not Found");
		}
	}

}
