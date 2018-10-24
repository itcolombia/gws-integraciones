package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
	@NotNull
	private Integer idTipoArchivo;
	@JsonIgnore
	@NotNull
	private Integer requerido;
	@NotNull
	@Size(max = 20)
	private String serieDocumento;
	@NotNull
	@Size(max = 20)
	private String numeroDocumento;
	@NotNull
	@Size(max = 50)
	private String nombreArchivo;
	@Size(max = 1024)
	private String rutaArchivoCompleta;
	@Size(max = 100)
	private String arg0;
	@JsonIgnore
	@Size(max = 100)
	private String arg1;
	@JsonIgnore
	@Size(max = 100)
	private String arg2;
	@JsonIgnore
	@Size(max = 100)
	private String arg3;
	@JsonIgnore
	@Size(max = 100)
	private String arg4;
	@Size(max = 50)
	private String status;
	private boolean archivoCreado;
	@JsonIgnore
	private LocalDateTime statusDateCreado;
	@JsonIgnore
	private LocalDateTime statusDateRecibido;
	@JsonIgnore
	private LocalDateTime statusDateDescarga;
	@JsonIgnore
	private LocalDateTime statusDateUltimaDescarga;

	@Builder
	public DocumentosDigitalesDto(Integer id, Integer idSolicitud, @NotNull Integer idTipoArchivo,
			@NotNull Integer requerido, @NotNull @Size(max = 20) String serieDocumento,
			@NotNull @Size(max = 20) String numeroDocumento, @NotNull @Size(max = 50) String nombreArchivo,
			@Size(max = 50) String rutaArchivoCompleta, @Size(max = 100) String arg0, @Size(max = 100) String arg1,
			@Size(max = 100) String arg2, @Size(max = 100) String arg3, @Size(max = 100) String arg4,
			@Size(max = 50) String status, boolean archivoCreado, LocalDateTime statusDateCreado,
			LocalDateTime statusDateRecibido, LocalDateTime statusDateDescarga,
			LocalDateTime statusDateUltimaDescarga) {
		super(id);
		this.idSolicitud = idSolicitud;
		this.idTipoArchivo = idTipoArchivo;
		this.requerido = requerido;
		this.serieDocumento = serieDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombreArchivo = nombreArchivo;
		this.rutaArchivoCompleta = rutaArchivoCompleta;
		this.arg0 = arg0;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.arg4 = arg4;
		this.status = status;
		this.archivoCreado = archivoCreado;
		this.statusDateCreado = statusDateCreado;
		this.statusDateRecibido = statusDateRecibido;
		this.statusDateDescarga = statusDateDescarga;
		this.statusDateUltimaDescarga = statusDateUltimaDescarga;
	}

}
