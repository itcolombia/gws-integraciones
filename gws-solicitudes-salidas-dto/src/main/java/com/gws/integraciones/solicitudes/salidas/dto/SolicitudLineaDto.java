package com.gws.integraciones.solicitudes.salidas.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
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
@Builder
public class SolicitudLineaDto extends EntityDto<Integer> {


	private int lineNum;
	@NotNull
	@Size(max = 100)
	private String objType;
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@NotNull
	@Size(max = 400)
	private String dscription;
	@NotNull
	private BigDecimal quantity;
	@NotNull
	@Size(max = 32)
	private String whsCode;
	@NotNull
	@Size(max = 32)
	private String filler;
	@Size(max = 40)
	private String predistribucion;
	@NotNull
	@Size(max = 508)
	private String licTradNum;
	@Builder
	public SolicitudLineaDto(Integer id, int lineNum, @NotNull @Size(max = 100) String objType,
			@NotNull @Size(max = 20) String itemCode, @NotNull @Size(max = 400) String dscription,
			@NotNull BigDecimal quantity, @NotNull @Size(max = 32) String whsCode,
			@NotNull @Size(max = 32) String filler, @Size(max = 40) String predistribucion,
			@NotNull @Size(max = 508) String licTradNum) {
		super(id);
		this.lineNum = lineNum;
		this.objType = objType;
		this.itemCode = itemCode;
		this.dscription = dscription;
		this.quantity = quantity;
		this.whsCode = whsCode;
		this.filler = filler;
		this.predistribucion = predistribucion;
		this.licTradNum = licTradNum;
	}
	

}
