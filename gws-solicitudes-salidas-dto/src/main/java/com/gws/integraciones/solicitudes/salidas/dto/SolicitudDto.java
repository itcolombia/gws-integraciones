package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
@Builder

public class SolicitudDto extends EntityDto<Integer> {


	@Size(max = 20)
	private String codCliente;
	@NotNull
	@Size(max = 13)
	private String tipoServicio;
	@NotNull
	@Size(max = 20)
	private String seriesName;
	private int docNum;
	@NotNull
	@Size(max = 8000)
	private String direccion;
	@NotNull
	@Size(max = 40)
	private String codDane;
	@NotNull
	@Size(max = 64)
	private String nit;
	@NotNull
	@Size(max = 200)
	private String razonSocial;
	@NotNull
	private LocalDateTime feMi;
	@NotNull
	private LocalDateTime feMa;
	@NotNull
	private LocalTime hoMi;
	@NotNull
	private LocalTime hoMa;
	private int uGwPuerto;
	private Integer docNumEntrega;
	@Size(max = 16)
	private String seriesNameEntrega;
	@NotNull
	private LocalDateTime createDate;
	@NotNull
	private LocalDateTime updateDate;
	@NotNull
	@Size(max = 20)
	private String uTipoVenta;
	@NotNull
	@Size(max = 20)
	private String numAtCard;
	@NotNull
	@Size(max = 40)
	private String objType;
	private int series;
	@NotNull
	@Size(max = 40)
	private String groupName;
	@NotNull
	@Size(max = 200)
	private String shipToCode;
	@NotNull
	private String address2;
	@NotNull
	@Size(max = 8000)
	private String uWuid;
	@NotNull
	private LocalDateTime docDate;
	@NotNull
	@Size(max = 8000)
	private String comments;
	@NotNull
	@Size(max = 7)
	private String manejaRecaudo;
	@NotNull
	@Size(max = 20)
	private String status;
	private LocalDateTime statusDate;
	private List<SolicitudLineaDto> lineas;
	@Builder
	public SolicitudDto(Integer id, @Size(max = 20) String codCliente, @NotNull @Size(max = 13) String tipoServicio,
			@NotNull @Size(max = 20) String seriesName, int docNum, @NotNull @Size(max = 8000) String direccion,
			@NotNull @Size(max = 40) String codDane, @NotNull @Size(max = 64) String nit,
			@NotNull @Size(max = 200) String razonSocial, @NotNull LocalDateTime feMi, @NotNull LocalDateTime feMa,
			@NotNull LocalTime hoMi, @NotNull LocalTime hoMa, int uGwPuerto, Integer docNumEntrega,
			@Size(max = 16) String seriesNameEntrega, @NotNull LocalDateTime createDate,
			@NotNull LocalDateTime updateDate, @NotNull @Size(max = 20) String uTipoVenta,
			@NotNull @Size(max = 20) String numAtCard, @NotNull @Size(max = 40) String objType, int series,
			@NotNull @Size(max = 40) String groupName, @NotNull @Size(max = 200) String shipToCode,
			@NotNull String address2, @NotNull @Size(max = 8000) String uWuid, @NotNull LocalDateTime docDate,
			@NotNull @Size(max = 8000) String comments, @NotNull @Size(max = 7) String manejaRecaudo,
			@NotNull @Size(max = 20) String status, LocalDateTime statusDate, List<SolicitudLineaDto> lineas) {
		super(id);
		this.codCliente = codCliente;
		this.tipoServicio = tipoServicio;
		this.seriesName = seriesName;
		this.docNum = docNum;
		this.direccion = direccion;
		this.codDane = codDane;
		this.nit = nit;
		this.razonSocial = razonSocial;
		this.feMi = feMi;
		this.feMa = feMa;
		this.hoMi = hoMi;
		this.hoMa = hoMa;
		this.uGwPuerto = uGwPuerto;
		this.docNumEntrega = docNumEntrega;
		this.seriesNameEntrega = seriesNameEntrega;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.uTipoVenta = uTipoVenta;
		this.numAtCard = numAtCard;
		this.objType = objType;
		this.series = series;
		this.groupName = groupName;
		this.shipToCode = shipToCode;
		this.address2 = address2;
		this.uWuid = uWuid;
		this.docDate = docDate;
		this.comments = comments;
		this.manejaRecaudo = manejaRecaudo;
		this.status = status;
		this.statusDate = statusDate;
		this.lineas = lineas;
	}

	

}
