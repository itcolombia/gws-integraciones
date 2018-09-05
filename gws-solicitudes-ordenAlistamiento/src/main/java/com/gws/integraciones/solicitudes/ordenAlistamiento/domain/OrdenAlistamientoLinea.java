package com.gws.integraciones.solicitudes.ordenAlistamiento.domain;

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
@Table(name = "OrdenesAlistamientoLineas")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrdenAlistamientoLinea extends BaseEntity<Integer> {

	@Column(name = "idOrdenAlistamiento")
	private Integer idOrdenAlistamiento;
	@Column(name = "lineNum")
	private Integer lineNum;
	@Column(name = "subLineNum")
	private Integer subLineNum;
	@Column(name = "itemCode", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String itemCode;
	@Column(name = "whsCode", length = 20, nullable = false)
	@NotNull
	@Size(max = 20)
	private String whsCode;
	@Column(name = "cantDespachada", nullable = false)
	private int cantDespachada;
	@Column(name = "cantNoDespachada", nullable = false)
	private int cantNoDespachada;
	@Column(name = "estadoOpl", length = 50)
	@Size(max = 50)
	private String estadoOpl;
	@Column(name = "bodegaOpl", length = 50)
	@Size(max = 50)
	private String bodegaOpl;

}
