package com.gws.integraciones.solicitudes.salidas.dto;

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
public class OrdenEntregaLineaDto {

	private Integer id;
	@NotNull
	private Integer idOrdenEntrega;
	private int linNum;
	@Size(max = 20)
	private String itemCode;
	@Size(max = 16)
	private String whsCode;
	private Integer cantEntregada;
	private Integer cantNoEntregada;
	@Size(max = 100)
	private String estadoOplRecibo;
	@Size(max = 20)
	private String bodegaOplRecibo;
	@Size(max = 20)
	private String tipoOrden;
	@Size(max = 40)
	private String numOrdenRechazo;

}
