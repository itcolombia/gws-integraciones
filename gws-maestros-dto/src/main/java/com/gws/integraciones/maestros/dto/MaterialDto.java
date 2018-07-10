package com.gws.integraciones.maestros.dto;

import java.time.LocalDate;

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

public class MaterialDto {
	
	@JsonIgnore
	private Integer id;
	
	private Integer fatherId;
	
	private Integer childNum;
	
	private Integer codeId;
	
	private Integer quantity;
	
	@JsonIgnore
	private LocalDate createDate;
	
	@JsonIgnore
	private LocalDate updateDate;
	
}
