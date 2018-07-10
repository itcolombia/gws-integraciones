package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDateTime;

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
public class OrdenEntregaDto {

	private Integer id;
	private Integer idSolicitud;
	@Size(max = 10)
	private String estadoEntrega;
	@Size(max = 50)
	private String causalEstadoEntrega;
	private LocalDateTime fechayHoraEntrega;
	@Size(max = 20)
	private String personaRecibe;
	private Integer identificacionPersona;

}
