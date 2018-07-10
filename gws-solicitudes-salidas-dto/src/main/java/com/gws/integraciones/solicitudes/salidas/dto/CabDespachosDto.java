package com.gws.integraciones.solicitudes.salidas.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
public class CabDespachosDto {
	
	
	private Integer id;
	
	@JsonIgnore
	private String objType;
	
	private String tipoDocumento;
	
	private String orden;
	
	private String seriesName;
	
	private String docNum;
	
	private String nit;
	
	private String razonSocial;
	
	private String groupName;
	
	@JsonIgnore
	private String shipToCode;
	
	@JsonIgnore
	private String campoS;
	
	private String direccion;

	private String codDane;
	
	private LocalDate docDate;

	private String feMi;
	
	private String feMa;
	
	private String horaMin;
	
	private String horaMax;
	
	private String comments;
	
	@JsonIgnore
	private String campo1;
	
	@JsonIgnore
	private String manejaRecaudo;
	
	@JsonIgnore
	private String puerto;
	
	private LocalDate createDate;

	@JsonIgnore
	private LocalDate updateDate;
	
	@JsonIgnore	
	private String series;
	
	@JsonIgnore
	private String u_Tipo_Venta;
	
	private String status;

	private LocalDateTime statusDate;

	private List<DetDespachosDto> lineas;

}
