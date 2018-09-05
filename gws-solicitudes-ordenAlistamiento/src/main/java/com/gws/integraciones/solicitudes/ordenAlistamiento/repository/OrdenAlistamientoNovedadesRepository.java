package com.gws.integraciones.solicitudes.ordenAlistamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.ordenAlistamiento.domain.OrdenAlistamientoNovedades;

public interface OrdenAlistamientoNovedadesRepository extends JpaRepository<OrdenAlistamientoNovedades, Integer> {
	
}
