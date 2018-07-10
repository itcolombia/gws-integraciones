package com.gws.integraciones.solicitudes.salidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.DetDespachos;


public interface DetDespachosRepository extends JpaRepository<DetDespachos, Integer> {
	
	DetDespachos findOneById(int id);
	
	List<DetDespachos> findAllById(int id);

}
