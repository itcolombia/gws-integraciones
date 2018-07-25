package com.gws.integraciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.domain.ErrorIntegracion;

public interface ErrorIntegracionRepository extends JpaRepository<ErrorIntegracion, Integer> {

}
