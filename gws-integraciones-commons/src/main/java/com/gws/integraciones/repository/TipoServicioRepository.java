package com.gws.integraciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.domain.TipoServicios;

public interface TipoServicioRepository extends JpaRepository<TipoServicios, Integer> {
	

}
