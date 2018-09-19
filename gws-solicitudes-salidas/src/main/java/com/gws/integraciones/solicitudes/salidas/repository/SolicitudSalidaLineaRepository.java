package com.gws.integraciones.solicitudes.salidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.SolicitudSalidaLinea;

public interface SolicitudSalidaLineaRepository extends JpaRepository<SolicitudSalidaLinea, Integer> {

	SolicitudSalidaLinea findOneById(int id);

	List<SolicitudSalidaLinea> findAllByIdSolicitud(int idSolicitud);

}
