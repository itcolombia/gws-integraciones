package com.gws.integraciones.solicitudes.salidas.dto;

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
public class OrdenAlistamientoSubLineaDto {

	  private Integer id; 
	  private Integer idAlistamientoLinea; 
	 @Size(max = 100) private String causalNoDespacho; 

}
