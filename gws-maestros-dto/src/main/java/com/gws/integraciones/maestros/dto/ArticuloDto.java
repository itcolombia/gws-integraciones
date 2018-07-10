package com.gws.integraciones.maestros.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloDto {

	private Integer id;

	private String itemCode;

	private String itemName;

	private String treeType;

	@JsonIgnore
	private LocalDate createDate;

	private LocalDate updateDate;

	private String status;

	private LocalDateTime statusDate;

	public boolean isHijos() {
		if("P".equals(treeType)) {
			return true;
		}
		else {
			return false;
		}
	}
}
