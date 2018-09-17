package com.gws.integraciones.solicitudes.DocumentosDespacho.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gws.integraciones.core.dto.EntityDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoDespachoDto extends EntityDto<Integer> {


	private Integer idSolicitud;
	@NotNull
	@Size(max = 40)
	private String prefijoPedido;
	@NotNull
	@Size(max = 40)
	private String numeroPedido;
	@NotNull
	@Size(max = 40)
	private String prefijoFactura;
	@NotNull
	@Size(max = 40)
	private String numeroFactura;
	
	@Builder
	public DocumentoDespachoDto(Integer id, Integer idSolicitud, @NotNull @Size(max = 40) String prefijoPedido,
			@NotNull @Size(max = 40) String numeroPedido, @NotNull @Size(max = 40) String prefijoFactura,
			@NotNull @Size(max = 40) String numeroFactura) {
		super(id);
		this.idSolicitud = idSolicitud;
		this.prefijoPedido = prefijoPedido;
		this.numeroPedido = numeroPedido;
		this.prefijoFactura = prefijoFactura;
		this.numeroFactura = numeroFactura;
	}

	
}
