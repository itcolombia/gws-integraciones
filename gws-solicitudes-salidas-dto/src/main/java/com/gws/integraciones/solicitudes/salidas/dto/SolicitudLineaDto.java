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

	@NotNull
	private Integer idSolicitud;
	private int lineNum;
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@NotNull
	@Size(max = 400)
	private String dscription;
	private int quantity;
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
	@Size(max = 508)
	private String licTradNum;
	@Builder
	public SolicitudLineaDto(Integer id, @NotNull Integer idSolicitud, int lineNum,
			@NotNull @Size(max = 20) String itemCode, @NotNull @Size(max = 400) String dscription, int quantity,
			@NotNull @Size(max = 32) String whsCode, @NotNull @Size(max = 40) String predistribucion,
			@NotNull @Size(max = 32) String filler, @NotNull @Size(max = 508) String licTradNum) {
		super(id);
		this.idSolicitud = idSolicitud;
		this.lineNum = lineNum;
		this.itemCode = itemCode;
		this.dscription = dscription;
		this.quantity = quantity;
		this.whsCode = whsCode;
		this.predistribucion = predistribucion;
		this.filler = filler;
		this.licTradNum = licTradNum;
	}
	

}
