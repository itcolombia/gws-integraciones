package com.gws.integraciones.solicitudes.DocumentosDespacho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.DocumentosDespacho.domain.DocumentoDespachoLinea;

public interface DocumentoDespachoLineaRepository extends JpaRepository<DocumentoDespachoLinea, Integer> {
	
	DocumentoDespachoLinea findOneById(int id);
	
	List<DocumentoDespachoLinea> findAllByIdDocumentDespacho(int idSolicitud);
	
}
