package com.gws.integraciones.solicitudes.salidas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.OrdenAlistamientoNovedades;

public interface OrdenAlistamientoNovedadesRepository extends JpaRepository<OrdenAlistamientoNovedades, Integer> {
	
}
