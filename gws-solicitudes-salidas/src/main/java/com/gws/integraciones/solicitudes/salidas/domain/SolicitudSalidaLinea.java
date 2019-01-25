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
@Table(name = "SolicitudesLineas")
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
	@Column(name = "descripcion", length = 400, nullable = false)
	@NotNull
	@Size(max = 400)
	private String dscription;
	@Column(name = "cantidad", nullable = false)
	private int quantity;
	@Column(name = "cantidadAsignada")
	private Integer quantityAsignada;
	@Column(name = "cantidadNoAsignada")
	private Integer quantityNoAsignada;
	@Column(name = "almacen", length = 32, nullable = false)
	@NotNull
	@Size(max = 32)
	private String whsCode;
	@Column(name = "predistribucion", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String predistribucion;
	@Column(name = "precioEmpresa", nullable = false)
	@NotNull
	private BigDecimal valorUnit;
	@Column(name = "precioCliente")
	private BigDecimal valorCliente;
	@Column(name = "descuento")
	private BigDecimal descuento;
	@Column(name = "icoEmpresa")
	private BigDecimal icoGws;
	@Column(name = "icoCliente")
	private BigDecimal icoCliente;
//	@Column(name = "statusLinea", length = 20)
//	@Size(max = 20)
//	private String statusLinea;

}
