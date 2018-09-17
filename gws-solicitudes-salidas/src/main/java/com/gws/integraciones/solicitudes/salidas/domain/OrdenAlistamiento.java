package com.gws.integraciones.solicitudes.salidas.domain;

import java.time.LocalDateTime;

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
@Table(name = "OrdenesAlistamiento")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrdenAlistamiento extends BaseEntity<Integer> {

	@Column(name = "idSolicitud")
	private Integer idSolicitud;
	@Column(name = "numeroOrdenAlistamiento", length = 50)
	@Size(max = 50)
	private String numeroOrdenAlistamiento;
	@Column(name = "tipoOrden", length = 50)
	@Size(max = 50)
	private String tipoOrden;
	@Column(name = "fechaHoraOrden")
	private LocalDateTime fechaHoraOrden;
	@Column(name = "fechaTransaccionOrden")
	private LocalDateTime fechaTransaccionOrden;

}
