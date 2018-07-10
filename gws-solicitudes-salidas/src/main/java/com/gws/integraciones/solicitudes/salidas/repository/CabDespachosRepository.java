package com.gws.integraciones.solicitudes.salidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.CabDespachos;

public interface CabDespachosRepository extends JpaRepository<CabDespachos, Integer> {
	
	CabDespachos findOneById(Integer id);
	
	List<CabDespachos> findAllByDocNum(List<Integer> docNum);
	
	List<CabDespachos> findAllByStatusIn(List<String> status);
	
	List<CabDespachos> findAllByStatus(String status);
}
