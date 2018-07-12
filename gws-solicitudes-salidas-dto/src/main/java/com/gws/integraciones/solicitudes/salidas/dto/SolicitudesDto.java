package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

public class SolicitudesDto {
	@NotNull
	private Integer id;
	@Size(max = 20)
	private String codCliente;
	@Size(max = 13)
	private String tipoServicio;
	@Size(max = 16)
	private String seriesName;
	private int docNum;
	@Size(max = 8000)
	private String direccion;
	@Size(max = 40)
	private String codDane;
	@Size(max = 64)
	private String nit;
	@NotNull
	@Size(max = 200)
	private String razonSocial;
	private LocalDateTime feMi;
	private LocalDateTime feMa;
	@Size(max = 20)
	private String hoMi;
	@Size(max = 20)
	private String hoMa;
	private Integer uGwPuerto;
	private Integer docNumEntrega;
	@Size(max = 16)
	private String SeriesNameEntrega;
	private LocalDateTime createDate;
	@NotNull
	private LocalDateTime updateDate;
	@Size(max = 20)
	private String uTipoVenta;
	@Size(max = 20)
	private String NumAtCard;
	@Size(max = 40)
	private String ObjType;
	private Integer Series;
	@Size(max = 40)
	private String GroupName;
	@Size(max = 200)
	private String ShipToCode;
	@Size(max = 100)
	private String Address2;
	@Size(max = 8000)
	private String uWuid;
	private LocalDateTime DocDate;
	@Size(max = 8000)
	private String Comments;
	@Size(max = 7)
	private String ManejaRecaudo;
	@Size(max = 2)
	private String Status;
	private LocalDateTime StatusDate;

}
