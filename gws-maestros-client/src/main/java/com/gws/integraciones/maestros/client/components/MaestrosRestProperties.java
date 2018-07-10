package com.gws.integraciones.maestros.client.components;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.gws.integraciones.core.web.client.configuration.RestProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix = "com.gws.integraciones.maestros.rest")
@Getter
@Setter
@ToString
@Validated
public class MaestrosRestProperties implements RestProperties {

	private String basePath;
}

