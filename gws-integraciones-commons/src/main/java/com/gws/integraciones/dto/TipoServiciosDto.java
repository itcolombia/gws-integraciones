package com.gws.integraciones.dto;

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
public class TipoServiciosDto {
	
	private Integer id;
	@NotNull
	@Size(max = 50)
	private String codTipoServicio;
	@NotNull
	@Size(max = 50)
	private String tipoServicio;

}
