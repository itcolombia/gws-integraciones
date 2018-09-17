package com.gws.integraciones.solicitudes.salidas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.gws.integraciones.core.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "OrdenesAlistamientoNovedades")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrdenAlistamientoNovedades extends BaseEntity<Integer> {

	@Column(name = "idAlistamientoLinea")
	private int idAlistamientoLinea;
	@Column(name = "causalNoDespacho", length = 50)
	@Size(max = 50)
	private String causalNoDespacho;
	@Column(name = "cantidad")
	private Integer cantidad;

}
