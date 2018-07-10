package com.gws.integraciones.solicitudes.salidas.client.components;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.gws.integraciones.core.web.client.configuration.RestProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix = "com.gws.integraciones.solicitudes.salidas.rest")
@Getter
@Setter
@ToString
@Validated
public class SalidasRestProperties implements RestProperties {

	private String basePath;
}

