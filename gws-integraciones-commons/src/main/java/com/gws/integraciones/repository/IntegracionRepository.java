package com.gws.integraciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.domain.Integracion;

public interface IntegracionRepository extends JpaRepository<Integracion, Integer> {
	Integracion findOneByCodigoIntegracion(String codigo);

	List<Integracion> findAllByCodigoIntegracionIn(List<String> codigos);

}
