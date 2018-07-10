package com.gws.integraciones.solicitudes.salidas.dto;

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
@Builder

public class SolicitudDto extends EntityDto<Integer> {

	
	private String codCliente;
	@Size(max = 13)
	private String tipoServicio;
	@Size(max = 16)
	private String seriesName;
	private int docNum;
	@Size(max = 8000)
	private String direccion;
	@Size(max = 40)
	private String codDane;
	@Size(max = 64)
	private String nit;
	@NotNull
	@Size(max = 200)
	private String razonSocial;
	private LocalDateTime feMi;
	private LocalDateTime feMa;
	@Size(max = 20)
	private String hoMi;
	@Size(max = 20)
	private String hoMa;
	private Integer uGwPuerto;
	private Integer docNumEntrega;
	@Size(max = 16)
	private String SeriesNameEntrega;
	private LocalDateTime createDate;
	@NotNull
	private LocalDateTime updateDate;
	@Size(max = 20)
	private String uTipoVenta;
	@Size(max = 20)
	private String numAtCard;
	@Size(max = 40)
	private String objType;
	private Integer Series;
	@Size(max = 40)
	private String groupName;
	@Size(max = 200)
	private String shipToCode;
	@Size(max = 100)
	private String address2;
	@Size(max = 8000)
	private String uWuid;
	private LocalDateTime docDate;
	@Size(max = 8000)
	private String comments;
	@Size(max = 7)
	private String manejaRecaudo;
	@Size(max = 2)
	private String status;
	private LocalDateTime statusDate;
	private List<SolicitudLineaDto> lineas;
	
	@Builder
	public SolicitudDto(Integer id, String codCliente, @Size(max = 13) String tipoServicio,
			@Size(max = 16) String seriesName, int docNum, @Size(max = 8000) String direccion,
			@Size(max = 40) String codDane, @Size(max = 64) String nit, @NotNull @Size(max = 200) String razonSocial,
			LocalDateTime feMi, LocalDateTime feMa, @Size(max = 20) String hoMi, @Size(max = 20) String hoMa,
			Integer uGwPuerto, Integer docNumEntrega, @Size(max = 16) String seriesNameEntrega,
			LocalDateTime createDate, @NotNull LocalDateTime updateDate, @Size(max = 20) String uTipoVenta,
			@Size(max = 20) String numAtCard, @Size(max = 40) String objType, Integer series,
			@Size(max = 40) String groupName, @Size(max = 200) String shipToCode, @Size(max = 100) String address2,
			@Size(max = 8000) String uWuid, LocalDateTime docDate, @Size(max = 8000) String comments,
			@Size(max = 7) String manejaRecaudo, @Size(max = 2) String status, LocalDateTime statusDate,
			List<SolicitudLineaDto> lineas) {
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
		SeriesNameEntrega = seriesNameEntrega;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.uTipoVenta = uTipoVenta;
		this.numAtCard = numAtCard;
		this.objType = objType;
		Series = series;
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
