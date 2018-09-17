package com.gws.integraciones.solicitudes.DocumentosDespacho.domain;

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
@Table(name = "DocumentosDespacho")
@DynamicUpdate
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DocumentoDespacho extends BaseEntity<Integer> {

	@Column(name = "idSolicitud")
	@NotNull
	private int idSolicitud;
	@Column(name = "prefijoPedido", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String prefijoPedido;
	@Column(name = "numeroPedido", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String numeroPedido;
	@Column(name = "prefijoFactura", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String prefijoFactura;
	@Column(name = "numeroFactura", length = 40, nullable = false)
	@NotNull
	@Size(max = 40)
	private String numeroFactura;

}