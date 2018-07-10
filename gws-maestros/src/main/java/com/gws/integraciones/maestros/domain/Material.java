package com.gws.integraciones.maestros.domain;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.gws.integraciones.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "DET_ITM1")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Material extends BaseEntity<Integer> {

	
	@Column(name = "FatherId", updatable = false)
	private Integer fatherId;

	@Column(name = "ChildNum", updatable = false)
	private Integer childNum;

	@Column(name = "CodeId", updatable = false)
	private Integer codeId;
	
	@Column(name = "Quantity", updatable = false)
	private Integer quantity;

	@Column(name = "CreateDate", updatable = false)
	private LocalDate createDate;

	@Column(name = "UpdateDate", updatable = false)
	private LocalDate updateDate;

}
