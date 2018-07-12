package com.gws.integraciones.domain;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name="INTEGRACIONES")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Integracion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PRIVATE)
	@Column(name="Id", updatable = false)
	private Integer id;
	
	@Column(name = "CodigoIntegracion", updatable=false)
	private String codigoIntegracion;
	
	@Column(name = "FechaUltimaConsulta", updatable=false)
	private LocalDate fechaUltimaConsulta;
	
}
