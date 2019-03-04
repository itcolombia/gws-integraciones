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
@Table(name = "ConfirmacionDespachoMercancia")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ConfirmacionDespachoMercacia extends BaseEntity<Integer> {

	@Column(name = "idSolicitud")
	@NotNull
	private int idSolicitud;
	@Column(name = "idOrdenAlistamiento")
	@NotNull
	private int idOrdenAlistamiento;
	@Column(name = "placasVehiculo", length = 10, nullable = false)
	@NotNull
	@Size(max = 10)
	private String placasVehiculo;
	@Column(name = "remesa", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String remesa;
	@Column(name = "transportadora", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String transportadora;
	@Column(name = "novedades", length = 50)
	@Size(max = 50)
	private String novedades;
	@Column(name = "itemCode", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@Column(name = "lineNum", nullable = false)
	private int lineNum;
	@Column(name = "cantidadDespachada", nullable = false)
	private int cantidadDespachada;
	@Column(name = "cantidadNoDespachada", nullable = false)
	private int cantidadNoDespachada;
	@Column(name = "despachado", nullable = false)
	private int despachado;
	@Column(name = "fechaDespacho", nullable = false)
	@NotNull
	private LocalDateTime fechaDespacho;
	@Column(name = "fechaRecibida", nullable = false)
	@NotNull
	private LocalDateTime fechaRecibida;
	@Column(name = "estadoDespacho", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String estadoDespacho;

}
