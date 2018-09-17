package com.gws.integraciones.solicitudes.salidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.DocumentoDespachoLinea;

public interface DocumentoDespachoLineaRepository extends JpaRepository<DocumentoDespachoLinea, Integer> {
	
	DocumentoDespachoLinea findOneById(Integer id);
	
	List<DocumentoDespachoLinea> findAllByIdDocumentoDespacho(Integer id);
	
}
