package com.gws.integraciones.solicitudes.salidas.domain;

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
@Table(name = "DocumentosDigitales")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DocumentosDigitales extends BaseEntity<Integer> {

	@Column(name = "idSolicitud")
	@NotNull
	private int idSolicitud;
	@Column(name = "idTipoArchivo")
	@NotNull
	private int idTipoArchivo;
	@Column(name = "requerido")
	@NotNull
	private int requerido;
	@Column(name = "serieDocumento", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String serieDocumento;
	@Column(name = "numeroDocumento", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String numeroDocumento;
	@Column(name = "nombreArchivo", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String nombreArchivo;
	@Column(name = "rutaArchivoCompleta", length = 1024)
	@Size(max = 1024)
	private String rutaArchivoCompleta;
	@Column(name = "arg0", length = 100)
	@Size(max = 100)
	private String arg0;
	@Column(name = "arg1", length = 100)
	@Size(max = 100)
	private String arg1;
	@Column(name = "arg2", length = 100)
	@Size(max = 100)
	private String arg2;
	@Column(name = "arg3", length = 100)
	@Size(max = 100)
	private String arg3;
	@Column(name = "arg4", length = 100)
	@Size(max = 100)
	private String arg4;
	@Column(name = "status", length = 50)
	@Size(max = 50)
	private String status;
	@Column(name = "archivoCreado")
	private Boolean archivoCreado;
	@Column(name = "DateCreado")
	private LocalDateTime statusDateCreado;
	@Column(name = "DateRecibido")
	private LocalDateTime statusDateRecibido;
	@Column(name = "DateDescarga")
	private LocalDateTime statusDateDescarga;
	@Column(name = "statusDateUltimaDescarga")
	private LocalDateTime statusDateUltimaDescarga;

}
