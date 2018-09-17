package com.gws.integraciones.solicitudes.DocumentosDespacho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.DocumentosDespacho.domain.DocumentoDespacho;
import com.gws.integraciones.solicitudes.DocumentosDespacho.domain.DocumentoDespachoLinea;

public interface DocumentoDespachoRepository extends JpaRepository<DocumentoDespacho, Integer> {

	DocumentoDespachoLinea findOneById(Integer id);
	

	List<DocumentoDespacho> findAllByDocNum(List<Integer> docNum);

	List<DocumentoDespacho> findAllByStatusIn(List<String> status);

	List<DocumentoDespacho> findAllByStatus(String status);

}
