package com.gws.integraciones.solicitudes.salidas.domain;



import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CAB_DESPACHOS")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor


public class CabDespachos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PRIVATE)
	
	@Column(name = "Id", updatable = false)
	private Integer id;
	
	@Column(name = "ObjType", updatable = false)
	private String objType;

	@Column(name = "TipoDocumento", updatable = false)
	private String tipoDocumento;

	@Column(name = "Orden", updatable = false)
	private String orden;

	@Column(name = "SeriesName", updatable = false)
	private String seriesName;

	@Column(name = "DocNum", updatable = false)
	private String docNum;

	@Column(name = "Nit", updatable = false)
	private String nit;
	
	@Column(name = "RazonSocial", updatable = false)
	private String razonSocial;
	
	@Column(name = "GroupName", updatable = false)
	private String groupName;
	
	@Column(name = "ShipToCode", updatable = false)
	private String shipToCode;
	
	@Column(name = "CampoS", updatable = false)
	private String campoS;
	
	@Column(name = "Direccion", updatable = false)
	private String direccion;
	
	@Column(name = "CodDane", updatable = false)
	private String codDane;
	
	@Column(name = "DocDate", updatable = false)
	private LocalDate docDate;
	
	@Column(name = "FeMi", updatable = false)
	private String feMi;

	@Column(name = "FeMa", updatable = false)
	private String feMa;
	
	@Column(name = "U_GW_estampilla", updatable = false)
	private String horaMin;
	
	@Column(name = "U_GW_tornaguia", updatable = false)
	private String horaMax;
	
	@Column(name = "Comments", updatable = false)
	private String comments;
	
	@Column(name = "CAMPO1", updatable = false)
	private String campo1;
	
	@Column(name = "ManejaRecaudo", updatable = false)
	private String manejaRecaudo;
	
	@Column(name = "Puerto", updatable = false)
	private String puerto;
	
	@Column(name = "CreateDate", updatable = false)
	private LocalDate createDate;

	@Column(name = "UpdateDate", updatable = false)
	private LocalDate updateDate;
	
	@Column(name = "Series", updatable = false)
	private String series;
	
	@Column(name = "U_TIPO_VENTA", updatable = false)
	private String u_Tipo_Venta;

	@Column(name = "Status")
	private String status;

	@Column(name = "StatusDate")
	private LocalDateTime statusDate;

}

