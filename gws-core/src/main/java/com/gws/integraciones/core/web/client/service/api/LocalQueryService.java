package com.gws.integraciones.core.web.client.service.api;

import java.io.Serializable;
import java.util.Optional;

public interface LocalQueryService<M, ID extends Serializable> {

	M findOneById(ID id);

	Optional<M> findById(ID id);

}