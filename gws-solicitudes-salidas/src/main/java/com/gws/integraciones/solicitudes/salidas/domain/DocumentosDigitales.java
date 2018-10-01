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
	@Column(name = "idRequerido")
	@NotNull
	private int idRequerido;
	@Column(name = "serieDocumentosDespacho", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String serieDocumentosDespacho;
	@Column(name = "numeroDocumentoDespacho", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String numeroDocumentoDespacho;
	@Column(name = "nombreArchivo", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String nombreArchivo;
	@Column(name = "rutaArchivoCompleta", length = 50)
	@Size(max = 50)
	private String rutaArchivoCompleta;
	@Column(name = "statusArchivos", length = 20)
	@Size(max = 20)
	private String statusArchivos;
	@Column(name = "statusDateCreado")
	private LocalDateTime statusDateCreado;
	@Column(name = "statusDateRecibido")
	private LocalDateTime statusDateRecibido;
	@Column(name = "statusDateDescarga")
	private LocalDateTime statusDateDescarga;
	@Column(name = "statusDateUltimaDescarga")
	private LocalDateTime statusDateUltimaDescarga;

}
