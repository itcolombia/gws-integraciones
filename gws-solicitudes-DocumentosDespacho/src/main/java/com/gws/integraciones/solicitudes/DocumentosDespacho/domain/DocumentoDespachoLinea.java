package com.gws.integraciones.solicitudes.DocumentosDespacho.domain;

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
public class DocumentoDespachoLinea extends BaseEntity<Integer> {

	@Column(name = "idDocumentoDespacho")
	@NotNull
	private int idDocumentoDespacho;
	@Column(name = "lineNum", nullable = false)
	private int lineNum;
	@Column(name = "itemCode", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@Column(name = "quantity", nullable = false)
	@NotNull
	private BigDecimal quantity;

}
