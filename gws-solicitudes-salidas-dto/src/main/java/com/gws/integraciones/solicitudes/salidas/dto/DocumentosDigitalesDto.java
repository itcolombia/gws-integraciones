package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDateTime;

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
public class DocumentosDigitalesDto extends EntityDto<Integer> {


	private Integer idSolicitud;
	@NotNull
	private Integer idTipoArchivo;
	@NotNull
	private Integer idRequerido;
	@NotNull
	@Size(max = 20)
	private String serieDocumentosDespacho;
	@NotNull
	@Size(max = 20)
	private String numeroDocumentoDespacho;
	@NotNull
	@Size(max = 50)
	private String nombreArchivo;
	@Size(max = 50)
	private String rutaArchivoCompleta;
	@Size(max = 20)
	private String statusArchivos;
	private LocalDateTime statusDateCreado;
	private LocalDateTime statusDateRecibido;	
	private LocalDateTime statusDateDescarga;
	private LocalDateTime statusDateUltimaDescarga;
	
	@Builder
	public DocumentosDigitalesDto(Integer id, Integer idSolicitud, @NotNull Integer idTipoArchivo,
			@NotNull Integer idRequerido, @NotNull @Size(max = 20) String serieDocumentosDespacho,
			@NotNull @Size(max = 20) String numeroDocumentoDespacho, @NotNull @Size(max = 50) String nombreArchivo,
			@Size(max = 50) String rutaArchivoCompleta, @Size(max = 20) String statusArchivos,
			LocalDateTime statusDateCreado, LocalDateTime statusDateRecibido, LocalDateTime statusDateDescarga,
			LocalDateTime statusDateUltimaDescarga) {
		super(id);
		this.idSolicitud = idSolicitud;
		this.idTipoArchivo = idTipoArchivo;
		this.idRequerido = idRequerido;
		this.serieDocumentosDespacho = serieDocumentosDespacho;
		this.numeroDocumentoDespacho = numeroDocumentoDespacho;
		this.nombreArchivo = nombreArchivo;
		this.rutaArchivoCompleta = rutaArchivoCompleta;
		this.statusArchivos = statusArchivos;
		this.statusDateCreado = statusDateCreado;
		this.statusDateRecibido = statusDateRecibido;
		this.statusDateDescarga = statusDateDescarga;
		this.statusDateUltimaDescarga = statusDateUltimaDescarga;
	}
	
	
	

}
