package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmacionDespachoMercanciaDto {

	private Integer id;
	@NotNull
	@Size(max = 50)
	private Integer idSolicitud;
	@NotNull
	private Integer IdOrdenAlistamiento;
	@NotNull
	@Size(max = 10)
	private String placasVehiculo;
	@NotNull
	@Size(max = 50)
	private String remesa;
	@NotNull
	@Size(max = 50)
	private String transportadora;
	@Size(max = 50)
	private String novedades;
	@NotNull
	@Size(max = 20)
	private String itemCode;
	private int lineNum;
	private int cantidadDespachada;
	private int cantidadNoDespachada;
	private int despachado;
	@NotNull
	private LocalDateTime fechaDespacho;
	@NotNull
	private LocalDateTime fechaRecibida;
	@NotNull
	@Size(max = 20)
	private String estadoDespacho;
}
