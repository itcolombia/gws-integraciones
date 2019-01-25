package com.gws.integraciones.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorIntegracionDto{

	private Integer id;
	@NotNull
	@Size(max = 50)
	private Integer idSolicitud; 
	private String integracion;
	@NotNull
	@Size(max = 100)
	private String idExterno;
	@NotNull
	@Size(max = 50)
	private String codigo;
	@NotNull
	private String mensaje;
	@NotNull
	@Size(max = 100)
	private String arg0;
	@NotNull
	@Size(max = 100)
	private String arg1;
	@NotNull
	@Size(max = 100)
	private String arg2;
	@NotNull
	@Size(max = 100)
	private String arg3;
	@NotNull
	@Size(max = 100)
	private String arg4;
	@NotNull
	@Size(max = 100)
	private String arg5;
	@NotNull
	@Size(max = 100)
	private String arg6;
	@NotNull
	@Size(max = 100)
	private String arg7;
	@NotNull
	@Size(max = 100)
	private String arg8;
	@NotNull
	@Size(max = 100)
	private String arg9;
	private int version;
	@NotNull
	private LocalDateTime fechaCreacion;
	@NotNull
	private LocalDateTime fechaModificacion;

}
