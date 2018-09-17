package com.gws.integraciones.solicitudes.salidas.dto;

import java.math.BigDecimal;

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
public class DocumentoDespachoLineaDto extends EntityDto<Integer> {

	@JsonIgnore
	private Integer id;
	@JsonIgnore
	private Integer idDocumentoDespacho;
	private int lineNum;
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@NotNull
	private BigDecimal quantity;

	@Builder
	public DocumentoDespachoLineaDto(Integer id, Integer id2, Integer idDocumentoDespacho, int lineNum,
			@NotNull @Size(max = 20) String itemCode, @NotNull BigDecimal quantity) {
		super(id);
		id = id2;
		this.idDocumentoDespacho = idDocumentoDespacho;
		this.lineNum = lineNum;
		this.itemCode = itemCode;
		this.quantity = quantity;
	}

}
