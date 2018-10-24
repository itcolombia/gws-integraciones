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

	private int docEntry;
	@NotNull
	@Size(max = 40)
	private String objType;
	private int series;
	@NotNull
	@Size(max = 20)
	private String seriesName;
	@NotNull
	@Size(max = 20)
	private String docNum;
	@Size(max = 40)
	private String numAtCard;
	@Size(max = 40)
	private String noPedidoExterno;
	@NotNull
	@Size(max = 20)
	private String codCliente;
	@NotNull
	@Size(max = 100)
	private String tipoServicio;
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
	private String comments;
	@NotNull
	private LocalDateTime docDate;
	@NotNull
	private LocalDateTime createDate;
	private int uGwPuerto;
	@NotNull
	@Size(max = 20)
	private String status;
	private LocalDateTime statusDate;
	private LocalDateTime statusDateRecibida;
	private LocalDateTime statusDateAceptada;
	private LocalDateTime statusDateRechazada;
	private LocalDateTime statusDateAlistada;
	@Size(max = 20)
	private String status1;

	private List<SolicitudLineaDto> lineas;

	@Builder
	public SolicitudDto(Integer id, int docEntry, @NotNull @Size(max = 40) String objType, int series,
			@NotNull @Size(max = 20) String seriesName, @NotNull @Size(max = 20) String docNum,
			@NotNull @Size(max = 40) String numAtCard, @Size(max = 40) String noPedidoExterno,
			@NotNull @Size(max = 20) String codCliente, @NotNull @Size(max = 100) String tipoServicio,
			@NotNull @Size(max = 40) String codClienteSap, @NotNull @Size(max = 40) String nit,
			@NotNull @Size(max = 200) String razonSocial, @NotNull @Size(max = 40) String groupName,
			@NotNull @Size(max = 200) String shipToCode, @NotNull @Size(max = 10) String codDane,
			@NotNull @Size(max = 300) String direccion, @NotNull LocalDate feMi, @NotNull LocalDate feMa,
			@NotNull @Size(max = 10) String hoMi, @NotNull @Size(max = 10) String hoMa,
			@NotNull @Size(max = 400) String comments, @NotNull LocalDateTime docDate,
			@NotNull LocalDateTime createDate, int uGwPuerto, @NotNull @Size(max = 20) String status,
			LocalDateTime statusDate, LocalDateTime statusDateRecibida, LocalDateTime statusDateAceptada,
			LocalDateTime statusDateRechazada, LocalDateTime statusDateAlistada, @Size(max = 20) String status1,
			List<SolicitudLineaDto> lineas) {
		super(id);
		this.docEntry = docEntry;
		this.objType = objType;
		this.series = series;
		this.seriesName = seriesName;
		this.docNum = docNum;
		this.numAtCard = numAtCard;
		this.noPedidoExterno = noPedidoExterno;
		this.codCliente = codCliente;
		this.tipoServicio = tipoServicio;
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
		this.comments = comments;
		this.docDate = docDate;
		this.createDate = createDate;
		this.uGwPuerto = uGwPuerto;
		this.status = status;
		this.statusDate = statusDate;
		this.statusDateRecibida = statusDateRecibida;
		this.statusDateAceptada = statusDateAceptada;
		this.statusDateRechazada = statusDateRechazada;
		this.statusDateAlistada = statusDateAlistada;
		this.status1 = status1;
		this.lineas = lineas;
	}



}
