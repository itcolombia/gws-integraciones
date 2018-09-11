package com.gws.integraciones.solicitudes.salidas.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gws.integraciones.core.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "SolicitudesDespacho")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SolicitudSalida extends BaseEntity<Integer> {

	@JsonIgnore
	@Column(name = "objType", length = 40, nullable = false)
	
	@NotNull
	@Size(max = 40)
	private String objType;
	
	@JsonIgnore
	@Column(name = "docEntry", nullable = false)
	private int docEntry;
	
	@Column(name = "codCliente", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String codCliente;
	
	@Column(name = "tipoServicio", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String tipoServicio;
	
	@Column(name = "seriesName", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String seriesName;
	
	@Column(name = "docNum", nullable = false)
	private int docNum;
	
	@Column(name = "direccion", length = 300, nullable = false)
	@NotNull
	@Size(max = 300)
	private String direccion;
	
	@Column(name = "codDane", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String codDane;
	
	@Column(name = "nit", length = 64, nullable = false)
	@NotNull
	@Size(max = 20)
	private String codCliente;
	@Column(name = "tipoServicio", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String tipoServicio;
	@Column(name = "nit", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String nit;
	
	@Column(name = "razonSocial", length = 200, nullable = false)
	@NotNull
	@Size(max = 200)
	private String razonSocial;
	
	@Column(name = "feMi", nullable = false)
	@NotNull
	private LocalDate feMi;
	
	@Column(name = "feMa", nullable = false)
	@NotNull
	private LocalDate feMa;
	
	@Column(name = "hoMi", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String hoMi;
	
	@Column(name = "hoMa", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String hoMa;
	
	@JsonIgnore
	@Column(name = "seriesNameEntrega", length = 20)
	@Size(max = 20)
	private String seriesNameEntrega;
	
	@JsonIgnore
	@Column(name = "docNumEntrega")
	private Integer docNumEntrega;
	
	@JsonIgnore
	@Column(name = "createDate", nullable = false)
	@NotNull
	private LocalDateTime createDate;
	
	@JsonIgnore
	@Column(name = "updateDate", nullable = false)
	@NotNull
	private LocalDateTime updateDate;
	
	@JsonIgnore
	@Column(name = "u_TIPO_VENTA", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String uTipoVenta;
	
	@Column(name = "numAtCard", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String numAtCard;
	
	@JsonIgnore
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
	
	@JsonIgnore
	@Column(name = "u_WUID")
	@NotNull
	private String uWuid;
	
	@JsonIgnore
	@Column(name = "u_GW_PUERTO", nullable = false)
	private int uGwPuerto;
	
	@JsonIgnore
	@Column(name = "docDate", nullable = false)
	@NotNull
	private LocalDateTime docDate;
	
	@JsonIgnore
	@Column(name = "comments", length = 8000, nullable = false)
	@NotNull
	private String comments;
	
	@JsonIgnore
	@Column(name = "manejaRecaudo", length = 7, nullable = false)
	@NotNull
	@Size(max = 7)
	private String manejaRecaudo;
	
	@Column(name = "status", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String status;
	
	@JsonIgnore
	@Column(name = "statusDate")
	private LocalDateTime statusDate;
	

}