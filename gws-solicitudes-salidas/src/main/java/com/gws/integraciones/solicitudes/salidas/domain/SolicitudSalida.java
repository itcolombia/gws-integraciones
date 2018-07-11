package com.gws.integraciones.solicitudes.salidas.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Column(name = "codCliente", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String codCliente;
	@Column(name = "tipoServicio", length = 13, nullable = false)
	@NotNull
	@Size(max = 13)
	private String tipoServicio;
	@Column(name = "seriesName", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String seriesName;
	@Column(name = "docNum", nullable = false)
	private int docNum;
	@Column(name = "direccion", length = 8000, nullable = false)
	@NotNull
	@Size(max = 8000)
	private String direccion;
	@Column(name = "codDane", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String codDane;
	@Column(name = "nit", length = 64, nullable = false)
	@NotNull
	@Size(max = 64)
	private String nit;
	@Column(name = "razonSocial", length = 200, nullable = false)
	@NotNull
	@Size(max = 200)
	private String razonSocial;
	@Column(name = "feMi", nullable = false)
	@NotNull
	private LocalDateTime feMi;
	@Column(name = "feMa", nullable = false)
	@NotNull
	private LocalDateTime feMa;
	@Column(name = "hoMi", nullable = false)
	@NotNull
	private LocalTime hoMi;
	@Column(name = "hoMa", nullable = false)
	@NotNull
	private LocalTime hoMa;
	@Column(name = "u_GW_PUERTO", nullable = false)
	private int uGwPuerto;
	@Column(name = "docNumEntrega")
	private Integer docNumEntrega;
	@Column(name = "seriesNameEntrega", length = 16)
	@Size(max = 16)
	private String seriesNameEntrega;
	@Column(name = "createDate", nullable = false)
	@NotNull
	private LocalDateTime createDate;
	@Column(name = "updateDate", nullable = false)
	@NotNull
	private LocalDateTime updateDate;
	@Column(name = "u_TIPO_VENTA", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String uTipoVenta;
	@Column(name = "numAtCard", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String numAtCard;
	@Column(name = "objType", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String objType;
	@Column(name = "series", nullable = false)
	private int series;
	@Column(name = "groupName", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String groupName;
	@Column(name = "shipToCode", length = 200, nullable = false)
	@NotNull
	@Size(max = 200)
	private String shipToCode;
	@Column(name = "address2", length = -1, nullable = false)
	@NotNull
	private String address2;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "u_WUID")
	@NotNull
	@Size(max = 8000)
	private String uWuid;
	@Column(name = "docDate", nullable = false)
	@NotNull
	private LocalDateTime docDate;
	@Column(name = "comments", length = 8000, nullable = false)
	@NotNull
	@Size(max = 8000)
	private String comments;
	@Column(name = "manejaRecaudo", length = 7, nullable = false)
	@NotNull
	@Size(max = 7)
	private String manejaRecaudo;
	@Column(name = "Status", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String Status;
	@Column(name = "statusDate")
	private LocalDateTime statusDate;

}
