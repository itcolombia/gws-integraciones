package com.gws.integraciones.solicitudes.DocumentosDespacho.dto;

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
public class DocumentoDespachoLineaDto extends EntityDto<Integer> {

	private Integer idDocumentoDespacho;
	private int lineNum;
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@NotNull
	private BigDecimal quantity;

}
