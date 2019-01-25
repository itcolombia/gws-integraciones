package com.gws.integraciones.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.gws.integraciones.core.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "SolicitudesErrores")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ErrorIntegracion extends BaseEntity<Integer> {

	@Column(name = "idSolicitud")
	private Integer idSolicitud; 
	
	@Column(name = "integracion", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String integracion;
	@Column(name = "idExterno", length = 50, nullable = false)
	@NotNull
	@Size(max = 100)
	private String idExterno;
	@Column(name = "codigo", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String codigo;
	@Column(name = "mensaje", length = -1, nullable = false)
	@NotNull
	private String mensaje;
	@Column(name = "arg0", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg0;
	@Column(name = "arg1", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg1;
	@Column(name = "arg2", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg2;
	@Column(name = "arg3", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg3;
	@Column(name = "arg4", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg4;
	@Column(name = "arg5", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg5;
	@Column(name = "arg6", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg6;
	@Column(name = "arg7", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg7;
	@Column(name = "arg8", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg8;
	@Column(name = "arg9", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String arg9;
	@Column(name = "version", nullable = false)
	private int version;
	@Column(name = "fechaCreacion", nullable = false)
	@NotNull
	private LocalDateTime fechaCreacion;
	@Column(name = "fechaModificacion", nullable = false)
	@NotNull
	private LocalDateTime fechaModificacion;


}
