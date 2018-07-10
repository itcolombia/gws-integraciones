package com.gws.integraciones.maestros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.maestros.domain.Material;

public interface MaterialeRepository extends JpaRepository<Material, Integer> {
	
	Material findOneByFatherId(int fatherId);
	
	List<Material> findAllByFatherId(int fatherId);
	

}
