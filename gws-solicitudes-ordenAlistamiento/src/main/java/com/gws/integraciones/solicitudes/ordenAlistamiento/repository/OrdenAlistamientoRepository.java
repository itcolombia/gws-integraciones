package com.gws.integraciones.solicitudes.ordenAlistamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.ordenAlistamiento.domain.OrdenAlistamiento;

public interface OrdenAlistamientoRepository extends JpaRepository<OrdenAlistamiento, Integer> {
	
	OrdenAlistamiento findOneById(Integer id);
}
