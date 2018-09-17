package com.gws.integraciones.solicitudes.salidas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.DocumentoDespacho;

public interface DocumentoDespachoRepository extends JpaRepository<DocumentoDespacho, Integer> {

	
	DocumentoDespacho findOneById(int id);
	
	Optional<DocumentoDespacho> findOneByIdSolicitud(int idSolicitud);
		
	

//	List<DocumentoDespacho> findAllByDocNum(List<Integer> docNum);

//	List<DocumentoDespacho> findAllByStatusIn(List<String> status);
//
//	List<DocumentoDespacho> findAllByStatus(String status);

}
