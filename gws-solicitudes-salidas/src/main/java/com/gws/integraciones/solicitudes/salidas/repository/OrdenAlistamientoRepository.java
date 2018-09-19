package com.gws.integraciones.solicitudes.salidas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.OrdenAlistamiento;

public interface OrdenAlistamientoRepository extends JpaRepository<OrdenAlistamiento, Integer> {

	OrdenAlistamiento findOneById(Integer id);
}
