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
@Table(name = "Solicitudes")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SolicitudSalida extends BaseEntity<Integer> {

	@Column(name = "codCliente", length = 20)
	@Size(max = 20)
	private String codCliente;
	@Column(name = "tipoServicio", length = 13)
	@Size(max = 13)
	private String tipoServicio;
	@Column(name = "SeriesName", length = 16)
	@Size(max = 16)
	private String seriesName;
	@Column(name = "DocNum", nullable = false)
	private int docNum;
	@Column(name = "Direccion", length = 8000)
	@Size(max = 8000)
	private String direccion;
	@Column(name = "CodDane", length = 40)
	@Size(max = 40)
	private String codDane;
	@Column(name = "Nit", length = 64)
	@Size(max = 64)
	private String nit;
	@Column(name = "RazonSocial", length = 200, nullable = false)
	@NotNull
	@Size(max = 200)
	private String razonSocial;
	@Column(name = "FeMi")
	private LocalDateTime feMi;
	@Column(name = "FeMa")
	private LocalDateTime feMa;
	@Column(name = "HoMi", length = 20)
	@Size(max = 20)
	private String hoMi;
	@Column(name = "HoMa", length = 20)
	@Size(max = 20)
	private String hoMa;
	@Column(name = "U_GW_PUERTO")
	private Integer uGwPuerto;
	@Column(name = "DocNumEntrega")
	private Integer docNumEntrega;
	@Column(name = "SeriesNameEntrega", length = 16)
	@Size(max = 16)
	private String seriesNameEntrega;
	@Column(name = "CreateDate")
	private LocalDateTime createDate;
	@Column(name = "UpdateDate", nullable = false)
	@NotNull
	private LocalDateTime updateDate;
	@Column(name = "U_TIPO_VENTA", length = 20)
	@Size(max = 20)
	private String uTipoVenta;
	@Column(name = "NumAtCard", length = 20)
	@Size(max = 20)
	private String numAtCard;
	@Column(name = "ObjType", length = 40)
	@Size(max = 40)
	private String objType;
	@Column(name = "Series")
	private Integer series;
	@Column(name = "groupName", length = 40)
	@Size(max = 40)
	private String groupName;
	@Column(name = "ShipToCode", length = 200)
	@Size(max = 200)
	private String shipToCode;
	@Column(name = "Address2", length = 100)
	@Size(max = 100)
	private String address2;
	
	@Column(name = "U_WUID")
	private String uWuid;
	@Column(name = "DocDate")
	private LocalDateTime docDate;
	@Column(name = "Comments", length = 8000)
	@Size(max = 8000)
	private String domments;
	@Column(name = "ManejaRecaudo", length = 7)
	@Size(max = 7)
	private String manejaRecaudo;
	@Column(name = "Status", length = 2)
	@Size(max = 2)
	private String status;
	@Column(name = "StatusDate")
	private LocalDateTime statusDate;

}
