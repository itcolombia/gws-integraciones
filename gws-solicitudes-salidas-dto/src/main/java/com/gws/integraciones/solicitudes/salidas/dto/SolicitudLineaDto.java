package com.gws.integraciones.solicitudes.salidas.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Builder
public class SolicitudLineaDto extends EntityDto<Integer> {

	private Integer id;
	@NotNull
	private Integer idSolicitud;
	private int lineNum;
	private int subLineNum;
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@NotNull
	@Size(max = 400)
	private String dscription;
	private int quantity;
	private Integer quantityAsignada;
	private Integer quantityNoAsignada;
	@NotNull
	@Size(max = 32)
	private String whsCode;
	@NotNull
	@Size(max = 40)
	private String predistribucion;
	@JsonIgnore
	@NotNull
	@Size(max = 32)
	private String filler;
	@JsonIgnore
	@NotNull
	private BigDecimal valorUnit;
	private BigDecimal icoGws;
	private BigDecimal icoCliente;
	@Size(max = 20)
	private String statusLinea;

}
