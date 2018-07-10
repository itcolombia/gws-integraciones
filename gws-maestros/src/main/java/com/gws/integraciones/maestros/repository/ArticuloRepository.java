package com.gws.integraciones.maestros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.maestros.domain.Articulo;


public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
	
	Articulo findOneByItemCode(String itemCode);
	
	List<Articulo> findAllByItemCodeIn(List<String> itemCode);
	
	List<Articulo> findAllByStatusIn(List<String> status);
	
	List<Articulo> findAllByStatus(String status);
	
}