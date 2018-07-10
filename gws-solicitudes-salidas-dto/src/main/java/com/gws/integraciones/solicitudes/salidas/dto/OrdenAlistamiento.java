package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDateTime;

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

public class OrdenAlistamiento extends EntityDto<Integer> {

	private Integer idSolicitud;
	@Size(max = 100)
	private String numeroOrdenAlistamiento;
	@Size(max = 100)
	private String tipoOrden;
	private LocalDateTime fechaHoraOrden;
	private LocalDateTime fechaTransaccionOrden;

}
