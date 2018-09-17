package com.gws.integraciones.solicitudes.salidas.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.OrdenAlistamientoLinea;

public interface OrdenAlistamientoLineaRepository extends JpaRepository<OrdenAlistamientoLinea, Integer> {

	OrdenAlistamientoLinea findOneById(int idOrdenAlistamiento);

	ArrayList<OrdenAlistamientoLinea> findAllByIdOrdenAlistamiento(int idOrdenAlistamiento);
}
