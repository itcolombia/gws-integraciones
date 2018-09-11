package com.gws.integraciones.solicitudes.salidas.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@JsonIgnore
	@NotNull
	@Size(max = 40)
	private String objType;

	@JsonIgnore
	private int docEntry;
	@NotNull
	@Size(max = 20)
	private String codCliente;
	@NotNull
	@Size(max = 100)
	private String tipoServicio;
	@NotNull
	@Size(max = 20)
	private String seriesName;
	
	private int docNum;
	
	@NotNull
	@Size(max = 300)
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
	private LocalDate feMi;
	
	@NotNull
	private LocalDate feMa;
	
	@NotNull
	@Size(max = 20)
	private String hoMi;
	
	@NotNull
	@Size(max = 20)
	private String hoMa;
	
	@JsonIgnore
	@Size(max = 20)
	private String seriesNameEntrega;
	
	@JsonIgnore
	private Integer docNumEntrega;
	
	@JsonIgnore
	@NotNull
	private LocalDateTime createDate;
	
	@JsonIgnore
	@NotNull
	private LocalDateTime updateDate;
	
	@JsonIgnore
	@NotNull
	@Size(max = 20)
	private String uTipoVenta;
	
	@NotNull
	@Size(max = 20)
	private String numAtCard;
	
	@JsonIgnore
	private int series;
	
	@NotNull
	@Size(max = 40)
	private String groupName;
	
	@NotNull
	@Size(max = 200)
	private String shipToCode;
	
	@NotNull
	private String address2;
	
	@JsonIgnore
	@NotNull
	private String uWuid;
	
	@JsonIgnore
	private int uGwPuerto;
	
	@JsonIgnore
	@NotNull
	private LocalDateTime docDate;
	
	@JsonIgnore
	@NotNull
	@Size(max = 10)
	private String hoMa;
	@NotNull
	@Size(max = 400)
	private String comments;
	
	@JsonIgnore
	@NotNull
	@Size(max = 7)
	private String manejaRecaudo;
	
	@NotNull
	@Size(max = 20)
	private String status;
	
	@JsonIgnore
	private LocalDateTime statusDate;
	
	private List<SolicitudLineaDto> lineas;

	@Builder
	public SolicitudDto(Integer id, @NotNull @Size(max = 40) String objType, int docEntry,
			@NotNull @Size(max = 20) String codCliente, @NotNull @Size(max = 100) String tipoServicio,
			@NotNull @Size(max = 20) String seriesName, int docNum, @NotNull @Size(max = 300) String direccion,
			@NotNull @Size(max = 40) String codDane, @NotNull @Size(max = 64) String nit,
			@NotNull @Size(max = 200) String razonSocial, @NotNull LocalDate feMi, @NotNull LocalDate feMa,
			@NotNull @Size(max = 20) String hoMi, @NotNull @Size(max = 20) String hoMa,
			@Size(max = 20) String seriesNameEntrega, Integer docNumEntrega, @NotNull LocalDateTime createDate,
			@NotNull LocalDateTime updateDate, @NotNull @Size(max = 20) String uTipoVenta,
			@NotNull @Size(max = 20) String numAtCard, int series, @NotNull @Size(max = 40) String groupName,
			@NotNull @Size(max = 200) String shipToCode, @NotNull String address2, @NotNull String uWuid, int uGwPuerto,
			@NotNull LocalDateTime docDate, @NotNull @Size(max = 8000) String comments,
			@NotNull @Size(max = 7) String manejaRecaudo, @NotNull @Size(max = 20) String status,
			LocalDateTime statusDate, List<SolicitudLineaDto> lineas) {
		super(id);
		this.objType = objType;
		this.docEntry = docEntry;
		this.codCliente = codCliente;
		this.tipoServicio = tipoServicio;
		this.seriesName = seriesName;
		this.docNum = docNum;
		this.numAtCard = numAtCard;
		this.codCliente = codCliente;
		this.tipoServicio = tipoServicio;
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
		this.seriesNameEntrega = seriesNameEntrega;
		this.docNumEntrega = docNumEntrega;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.uTipoVenta = uTipoVenta;
		this.numAtCard = numAtCard;
		this.series = series;
		this.groupName = groupName;
		this.shipToCode = shipToCode;
		this.address2 = address2;
		this.uWuid = uWuid;
		this.uGwPuerto = uGwPuerto;
		this.docDate = docDate;
		this.comments = comments;
		this.docDate = docDate;
		this.createDate = createDate;
		this.uGwPuerto = uGwPuerto;
		this.status = status;
		this.statusDate = statusDate;
		this.status1 = status1;
		this.lineas = lineas;
	}
}
