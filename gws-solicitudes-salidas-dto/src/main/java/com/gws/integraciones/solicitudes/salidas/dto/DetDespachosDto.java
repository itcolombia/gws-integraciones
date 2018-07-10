package com.gws.integraciones.solicitudes.salidas.dto;

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
public class DetDespachosDto {
	
	
	private Integer lineNum;
	
	@JsonIgnore
	private String objType;
	
	private String itemCode;

	private String dscription;
	
	private Float quantity;
	
	private String whsCode;

	private String filler;
	
	private String licTradNum;

	private String dian;
	
	private String precio;
	
}
