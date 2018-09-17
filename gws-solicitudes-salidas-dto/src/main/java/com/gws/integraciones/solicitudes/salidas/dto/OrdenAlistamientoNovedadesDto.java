package com.gws.integraciones.solicitudes.salidas.dto;

import javax.validation.constraints.Size;

import com.gws.integraciones.core.dto.EntityDto;

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
public class OrdenAlistamientoNovedadesDto extends EntityDto<Integer> {

	private Integer idAlistamientoLinea;
	@Size(max = 50)
	private String causalNoDespacho;
	private Integer cantidad;
	
	@Builder
	public OrdenAlistamientoNovedadesDto(Integer id, Integer idAlistamientoLinea,
			@Size(max = 50) String causalNoDespacho, Integer cantidad) {
		super(id);
		this.idAlistamientoLinea = idAlistamientoLinea;
		this.causalNoDespacho = causalNoDespacho;
		this.cantidad = cantidad;
	}

}
