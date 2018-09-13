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
	@Column(name = "subLineNum", nullable = false)
	private int subLineNum;
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
	@Column(name = "quantityAsignada")
	private Integer quantityAsignada;
	@Column(name = "quantityNoAsignada")
	private Integer quantityNoAsignada;
	@Column(name = "whsCode", length = 32, nullable = false)
	@NotNull
	@Size(max = 32)
	private String whsCode;
	@Column(name = "predistribucion", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String predistribucion;
	@Column(name = "valorUnit", nullable = false)
	@NotNull
	private BigDecimal valorUnit;
	@Column(name = "valorCliente")
	private BigDecimal valorCliente;
	@Column(name = "descuento")
	private BigDecimal descuento;
	@Column(name = "icoGws")
	private BigDecimal icoGws;
	@Column(name = "icoCliente")
	private BigDecimal icoCliente;
	@Column(name = "statusLinea", length = 20)
	@Size(max = 20)
	private String statusLinea;

}
