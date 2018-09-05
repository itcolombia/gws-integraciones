package com.gws.integraciones.maestros.domain;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.gws.integraciones.core.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Articulos")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Articulo extends BaseEntity<Integer> {

	@Column(name = "ItemCode", updatable = false)
	private String itemCode;

	@Column(name = "ItemName", updatable = false)
	private String itemName;

	@Column(name = "TreeType", updatable = false)
	private String treeType;

	@Column(name = "CreateDate", updatable = false)
	private LocalDate createDate;

	@Column(name = "UpdateDate", updatable = false)
	private LocalDate updateDate;

	@Column(name = "Status")
	private String status;

	@Column(name = "StatusDate")
	private LocalDateTime statusDate;

}