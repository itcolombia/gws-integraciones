package com.gws.integraciones.solicitudes.salidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.DocumentosDigitales;

public interface DocumentosDigitalesRepository extends JpaRepository<DocumentosDigitales, Integer> {

	DocumentosDigitales findOneById(Integer id);
	
	List<DocumentosDigitales> findAllByStatusArchivos(String statusArchivos );
}
