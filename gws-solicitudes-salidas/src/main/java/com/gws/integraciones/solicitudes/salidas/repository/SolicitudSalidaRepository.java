package com.gws.integraciones.solicitudes.salidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gws.integraciones.solicitudes.salidas.domain.SolicitudSalida;

public interface SolicitudSalidaRepository extends JpaRepository<SolicitudSalida, Integer> {

	SolicitudSalida findOneById(Integer id);

	List<SolicitudSalida> findAllByDocNum(List<Integer> docNum);

	List<SolicitudSalida> findAllByStatusIn(List<String> status);

	List<SolicitudSalida> findAllByStatus(String status);

}
