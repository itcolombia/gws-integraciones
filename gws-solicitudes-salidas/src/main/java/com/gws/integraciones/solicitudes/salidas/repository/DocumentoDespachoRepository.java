package com.gws.integraciones.solicitudes.salidas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.DocumentoDespacho;

public interface DocumentoDespachoRepository extends JpaRepository<DocumentoDespacho, Integer> {

	DocumentoDespacho findOneById(int id);

	Optional<DocumentoDespacho> findOneByIdSolicitud(int idSolicitud);

}
