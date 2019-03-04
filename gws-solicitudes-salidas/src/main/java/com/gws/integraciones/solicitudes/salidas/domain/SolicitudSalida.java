package com.gws.integraciones.solicitudes.salidas.domain;

import java.time.LocalDate;
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
@Table(name = "Solicitudes")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SolicitudSalida extends BaseEntity<Integer> {

//	@Column(name = "docEntry", nullable = false)
//	private int docEntry;
//	@Column(name = "objType", length = 40, nullable = false)
//	@NotNull
//	@Size(max = 40)
//	private String objType;
//	@Column(name = "series", nullable = false)
//	private int series;
	@Column(name = "nombreSerie", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String seriesName;
	@Column(name = "documento", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String docNum;
//	@Column(name = "ordenCompra", length = 40, nullable = false)
//	@NotNull
//	@Size(max = 40)
//	private String numAtCard;
//	@Column(name = "noPedidoExterno", length = 40)
//	@Size(max = 40)
//	private String noPedidoExterno;
	@Column(name = "codigoEmpresa", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String codCliente;
	@Column(name = "idTipoServicio", nullable = false)
	private int idTipoServicio;
	@Column(name = "terceroCodigoSap", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String codClienteSap;
	@Column(name = "terceroNit", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String nit;
	@Column(name = "terceroRazonSocial", length = 200, nullable = false)
	@NotNull
	@Size(max = 200)
	private String razonSocial;
	@Column(name = "nombreGrupo", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String groupName;
	@Column(name = "nombreDireccion", length = 200, nullable = false)
	@NotNull
	@Size(max = 200)
	private String shipToCode;
	@Column(name = "codigoDane", length = 10, nullable = false)
	@NotNull
	@Size(max = 10)
	private String codDane;
	@Column(name = "direccion", length = 300, nullable = false)
	@NotNull
	@Size(max = 300)
	private String direccion;
	@Column(name = "feMi", nullable = false)
	@NotNull
	private LocalDate feMi;
	@Column(name = "feMa", nullable = false)
	@NotNull
	private LocalDate feMa;
	@Column(name = "hoMi", length = 10, nullable = false)
	@NotNull
	@Size(max = 10)
	private String hoMi;
	@Column(name = "hoMa", length = 10, nullable = false)
	@NotNull
	@Size(max = 10)
	private String hoMa;
//	@Column(name = "comments", length = 400, nullable = false)
//	@NotNull
//	@Size(max = 400)
//	private String comments;
//	@Column(name = "docDate", nullable = false)
//	@NotNull
//	private LocalDateTime docDate;
//	@Column(name = "createDate", nullable = false)
//	@NotNull
//	private LocalDateTime dateCreacion;
//	@Column(name = "u_GW_PUERTO", nullable = false)
//	private int uGwPuerto;
	@Column(name = "status", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String status;
//	@Column(name = "statusDate")
//	private LocalDateTime statusDate;
	@Column(name = "dateRecibida")
	private LocalDateTime statusDateRecibida;
	@Column(name = "dateAceptada")
	private LocalDateTime statusDateAceptada;
	@Column(name = "dateRechazada")
	private LocalDateTime statusDateRechazada;
	@Column(name = "dateAlistada")
	private LocalDateTime statusDateAlistada;
	@Column(name = "dateDespacho")
	private LocalDateTime dateDespacho;
//	@Column(name = "status1", length = 20)
//	@Size(max = 20)
//	private String status1;

}