package com.gws.integraciones.solicitudes.salidas.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gws.integraciones.dto.EntityDto;

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
public class OrdenAlistamientoLineaDto extends EntityDto<Integer> {

	@NotNull
	private Integer idOrdenAlistamiento;
	private int lineNum;
	@Size(max = 20)
	private String itemCode;
	@Size(max = 20)
	private String whsCode;
	@Size(max = 20)
	private String cantSolicitada;
	private int cantDespachada;
	private Integer cantNoDespachada;
	@Size(max = 10)
	private String estadoOpl;
	@Size(max = 10)
	private String bodegaOpl;

}
