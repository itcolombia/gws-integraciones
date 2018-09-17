package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

public class OrdenAlistamientoDto extends EntityDto<Integer> {

	private Integer idSolicitud;
	@Size(max = 35)
	private String numeroOrdenAlistamiento;
	@Size(max = 50)
	private String tipoOrden;
	private LocalDateTime fechaHoraOrden;
	private LocalDateTime fechaTransaccionOrden;

	private List<OrdenAlistamientoLineaDto> alistamientoLineas =  new ArrayList<>();

	@Builder
	public OrdenAlistamientoDto(Integer id, Integer idSolicitud, @Size(max = 35) String numeroOrdenAlistamiento,
			@Size(max = 50) String tipoOrden, LocalDateTime fechaHoraOrden, LocalDateTime fechaTransaccionOrden,
			List<OrdenAlistamientoLineaDto> alistamientoLineas) {
		super(id);
		this.idSolicitud = idSolicitud;
		this.numeroOrdenAlistamiento = numeroOrdenAlistamiento;
		this.tipoOrden = tipoOrden;
		this.fechaHoraOrden = fechaHoraOrden;
		this.fechaTransaccionOrden = fechaTransaccionOrden;
		this.alistamientoLineas = alistamientoLineas;
	}
	


}
