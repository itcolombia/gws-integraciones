package com.gws.integraciones.solicitudes.salidas.domain;


import java.io.Serializable;

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
@Table(name = "DET_DESPACHOS")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DetDespachos implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PRIVATE)
	
	@Column(name = "Id", updatable = false)
	private Integer id;
	
	@Column(name = "LineNum" , updatable = false)
	private Integer lineNum;
	
	
	@Column(name = "ObjType", updatable = false)
	private String objType;
	
	@Column(name = "ItemCode", updatable = false)
	private String itemCode;
	
	@Column(name = "Dscription", updatable = false)
	private String dscription;
	
	@Column(name = "Quantity", updatable = false)
	private Float quantity;
	
	@Column(name = "WhsCode", updatable = false)
	private String whsCode;
	
	@Column(name = "Filler", updatable = false)
	private String filler;
	
	@Column(name = "LicTradNum", updatable = false)
	private String licTradNum;
	
	@Column(name = "Dian", updatable = false)
	private String dian;
	
	@Column(name = "Precio", updatable = false)
	private String precio;
	
	
}
