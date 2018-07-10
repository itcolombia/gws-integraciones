package com.gws.integraciones.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import com.gws.integraciones.demo.service.api.DownloadService;
import com.gws.integraciones.maestros.client.service.api.ArticuloLocalService;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DownloadServiceImpl implements DownloadService {

	@Autowired
	private ArticuloLocalService localService;

	@Override
	public void download() {
		val ids = localService.getAllByStatus("MI");

		for (Integer id : ids) {
			val articulo = localService.findById(id);

			log.info("id:{}, objeto:{}", id, articulo.toString());

			try {
				localService.confirmarRecibido(id);
			}catch(HttpStatusCodeException e) {
				log.error("{}:{}", e.getClass().getName(), e.getResponseBodyAsString());
			} catch (Exception e) {
				log.error("{}:{}", e.getClass().getName(), e.getMessage());
			}
		}
	}

}
