package com.gws.integraciones.solicitudes.salidas.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.gws.integraciones.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "SolicitudesLinea")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SolicitudSalidaLinea extends BaseEntity<Integer> {

	@Column(name = "lineNum", nullable = false)
	private int lineNum;
	@Column(name = "objType", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String objType;
	@Column(name = "itemCode", length = 20)
	@Size(max = 20)
	private String itemCode;
	@Column(name = "dscription", length = 400)
	@Size(max = 400)
	private String dscription;
	@Column(name = "quantity")
	private BigDecimal quantity;
	@Column(name = "whsCode", length = 32)
	@Size(max = 32)
	private String whsCode;
	@Column(name = "filler", length = 32)
	@Size(max = 32)
	private String filler;
	@Column(name = "predistribucion", length = 40)
	@Size(max = 40)
	private String predistribucion;
	@Column(name = "licTradNum", length = 508)
	@Size(max = 508)
	private String licTradNum;
	@Column(name = "precio")
	private Integer precio;

}
