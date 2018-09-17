package com.gws.integraciones.solicitudes.salidas.dto;

import java.util.ArrayList;
import java.util.List;

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
public class OrdenAlistamientoLineaDto extends EntityDto<Integer> {


	@NotNull
	private Integer idOrdenAlistamiento;
	private Integer lineNum;
	private Integer subLineNum;
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@NotNull
	@Size(max = 20)
	private String whsCode;
	private int cantDespachada;
	private int cantNoDespachada;
	@Size(max = 50)
	private String estadoOpl;
	@Size(max = 50)
	private String bodegaOpl;

	private List<OrdenAlistamientoNovedadesDto> alistamientoNovedades = new ArrayList<>();

	@Builder
	public OrdenAlistamientoLineaDto(Integer id, @NotNull Integer idOrdenAlistamiento, Integer lineNum,
			Integer subLineNum, @NotNull @Size(max = 20) String itemCode, @NotNull @Size(max = 20) String whsCode,
			int cantDespachada, int cantNoDespachada, @Size(max = 50) String estadoOpl,
			@Size(max = 50) String bodegaOpl, List<OrdenAlistamientoNovedadesDto> alistamientoNovedades) {
		super(id);
		this.idOrdenAlistamiento = idOrdenAlistamiento;
		this.lineNum = lineNum;
		this.subLineNum = subLineNum;
		this.itemCode = itemCode;
		this.whsCode = whsCode;
		this.cantDespachada = cantDespachada;
		this.cantNoDespachada = cantNoDespachada;
		this.estadoOpl = estadoOpl;
		this.bodegaOpl = bodegaOpl;
		this.alistamientoNovedades = alistamientoNovedades;
	}


	

}
