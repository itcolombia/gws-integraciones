package com.gws.integraciones.solicitudes.salidas.domain;

import java.math.BigDecimal;

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
@Table(name = "SolicitudesLinea")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SolicitudSalidaLinea extends BaseEntity<Integer> {

	@Column(name = "lineNum", nullable = false)
	private int lineNum;
	@Column(name = "objType", length = 100, nullable = false)
	@NotNull
	@Size(max = 100)
	private String objType;
	@Column(name = "itemCode", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@Column(name = "dscription", length = 400, nullable = false)
	@NotNull
	@Size(max = 400)
	private String dscription;
	@Column(name = "quantity", nullable = false)
	@NotNull
	private BigDecimal quantity;
	@Column(name = "whsCode", length = 32, nullable = false)
	@NotNull
	@Size(max = 32)
	private String whsCode;
	@Column(name = "filler", length = 32, nullable = false)
	@NotNull
	@Size(max = 32)
	private String filler;
	@Column(name = "predistribucion", length = 40)
	@Size(max = 40)
	private String predistribucion;
	@Column(name = "licTradNum", length = 508, nullable = false)
	@NotNull
	@Size(max = 508)
	private String licTradNum;

}
