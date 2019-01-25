package com.gws.integraciones.domain;

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
@Table(name = "TiposServicios")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TipoServicios extends BaseEntity<Integer> {

	@Column(name = "codTipoServicio", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String codTipoServicio;
	@Column(name = "tipoServicio", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String tipoServicio;

}
