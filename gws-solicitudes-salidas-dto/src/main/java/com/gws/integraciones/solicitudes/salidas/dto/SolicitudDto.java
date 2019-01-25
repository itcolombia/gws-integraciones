package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
public class SolicitudDto extends EntityDto<Integer> {

	// private int docEntry;
	// @NotNull
	// @Size(max = 40)
	// private String objType;
	// private int series;
	// @NotNull
	// @Size(max = 20)
	private String seriesName;
	@NotNull
	@Size(max = 20)
	private String docNum;
	@Size(max = 40)
	// private String numAtCard;
	// @Size(max = 40)
	// private String noPedidoExterno;
	// @NotNull
	// @Size(max = 20)
	private String codCliente;
	@NotNull
	@Size(max = 100)
	private String tipoServicio;
	private Integer idTipoServicio;
	@NotNull
	@Size(max = 40)
	private String codClienteSap;
	@NotNull
	@Size(max = 40)
	private String nit;
	@NotNull
	@Size(max = 200)
	private String razonSocial;
	@NotNull
	@Size(max = 40)
	private String groupName;
	@NotNull
	@Size(max = 200)
	private String shipToCode;
	@NotNull
	@Size(max = 10)
	private String codDane;
	@NotNull
	@Size(max = 300)
	private String direccion;
	@NotNull
	private LocalDate feMi;
	@NotNull
	private LocalDate feMa;
	@NotNull
	@Size(max = 10)
	private String hoMi;
	@NotNull
	@Size(max = 10)
	private String hoMa;
	@NotNull
	@Size(max = 400)
	// private String comments;
	// @NotNull
	private LocalDateTime docDate;
	@NotNull
	private LocalDateTime dateCreacion;
	// private int uGwPuerto;
	// @NotNull
	// @Size(max = 20)
	private String status;
	// private LocalDateTime statusDate;
	private LocalDateTime statusDateRecibida;
	private LocalDateTime statusDateAceptada;
	private LocalDateTime statusDateRechazada;
	private LocalDateTime statusDateAlistada;
	@Size(max = 20)
	// private String status1;

	private List<SolicitudLineaDto> lineas;
	
	@Builder
	public SolicitudDto(Integer id, String seriesName, @NotNull @Size(max = 20) String docNum,
			@Size(max = 40) String codCliente, @NotNull @Size(max = 100) String tipoServicio, Integer idTipoServicio,
			@NotNull @Size(max = 40) String codClienteSap, @NotNull @Size(max = 40) String nit,
			@NotNull @Size(max = 200) String razonSocial, @NotNull @Size(max = 40) String groupName,
			@NotNull @Size(max = 200) String shipToCode, @NotNull @Size(max = 10) String codDane,
			@NotNull @Size(max = 300) String direccion, @NotNull LocalDate feMi, @NotNull LocalDate feMa,
			@NotNull @Size(max = 10) String hoMi, @NotNull @Size(max = 10) String hoMa,
			@NotNull @Size(max = 400) LocalDateTime docDate, @NotNull LocalDateTime dateCreacion, String status,
			LocalDateTime statusDateRecibida, LocalDateTime statusDateAceptada, LocalDateTime statusDateRechazada,
			LocalDateTime statusDateAlistada, @Size(max = 20) List<SolicitudLineaDto> lineas) {
		super(id);
		this.seriesName = seriesName;
		this.docNum = docNum;
		this.codCliente = codCliente;
		this.tipoServicio = tipoServicio;
		this.idTipoServicio = idTipoServicio;
		this.codClienteSap = codClienteSap;
		this.nit = nit;
		this.razonSocial = razonSocial;
		this.groupName = groupName;
		this.shipToCode = shipToCode;
		this.codDane = codDane;
		this.direccion = direccion;
		this.feMi = feMi;
		this.feMa = feMa;
		this.hoMi = hoMi;
		this.hoMa = hoMa;
		this.docDate = docDate;
		this.dateCreacion = dateCreacion;
		this.status = status;
		this.statusDateRecibida = statusDateRecibida;
		this.statusDateAceptada = statusDateAceptada;
		this.statusDateRechazada = statusDateRechazada;
		this.statusDateAlistada = statusDateAlistada;
		this.lineas = lineas;
	}
	
}
