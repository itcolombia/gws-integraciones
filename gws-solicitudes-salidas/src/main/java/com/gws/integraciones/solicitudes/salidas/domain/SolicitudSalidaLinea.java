package com.gws.integraciones.solicitudes.salidas.domain;

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
@Table(name = "SolicitudesDespachoLineas")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SolicitudSalidaLinea extends BaseEntity<Integer> {

	@Column(name = "idSolicitud")
	@NotNull
	private int idSolicitud;
	@Column(name = "lineNum", nullable = false)
	private int lineNum;
	@Column(name = "itemCode", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@Column(name = "dscription", length = 400, nullable = false)
	@NotNull
	@Size(max = 400)
	private String dscription;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	@Column(name = "whsCode", length = 32, nullable = false)
	@NotNull
	@Size(max = 32)
	private String whsCode;
	@Column(name = "predistribucion", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String predistribucion;
	@JsonIgnore
	@Column(name = "filler", length = 32, nullable = false)
	@NotNull
	@Size(max = 32)
	private String filler;
	@JsonIgnore
	@Column(name = "licTradNum", length = 508, nullable = false)
	@NotNull
	private BigDecimal valorUnit;
	@Column(name = "icoGws")
	private BigDecimal icoGws;
	@Column(name = "icoCliente")
	private BigDecimal icoCliente;
	@Column(name = "statusLinea", length = 20)
	@Size(max = 20)
	private String statusLinea;

}
