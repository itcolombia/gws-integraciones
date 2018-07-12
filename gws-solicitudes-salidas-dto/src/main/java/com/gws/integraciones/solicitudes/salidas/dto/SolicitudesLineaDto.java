package com.gws.integraciones.solicitudes.salidas.dto;

import java.math.BigDecimal;

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
public class SolicitudesLineaDto {
	
	private Integer id;
	private int lineNum;
	@NotNull
	@Size(max = 20)
	private String objType;
	@Size(max = 20)
	private String itemCode;
	@Size(max = 400)
	private String dscription;
	private BigDecimal quantity;
	@Size(max = 32)
	private String whsCode;
	@Size(max = 32)
	private String filler;
	@Size(max = 40)
	private String predistribucion;
	@Size(max = 508)
	private String licTradNum;
	private Integer precio;

}
