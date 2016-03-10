/*******************************************************************************
 * Copyright (c) 2016 Institute for Pervasive Computing, ETH Zurich.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *    http://www.eclipse.org/org/documents/edl-v10.html.
 *
 * Contributors:
 *    Matthias Kovatsch - creator and main architect
 *    Yassin N. Hassan - architect and implementation
 *    Klaus Hartke - CoRE Lighting specification
 *******************************************************************************/
package ch.ethz.inf.vs.hypermedia.hartke.lighting.server;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;

import java.util.UUID;

/**
 * Created by ynh on 30/09/15.
 */
public class RandomLightingConfig extends LightingConfigResource {

	private final UpdateResource updateForm;

	public RandomLightingConfig(String name, LightServer srv) {
		super(name, srv);
		updateForm = new UpdateResource(UUID.randomUUID().toString());
		add(updateForm);
	}

	@Override
	public String getUpdateFormURI() {
		return updateForm.getURI();
	}

	@Override
	public void handlePUT(CoapExchange exchange) {
		exchange.respond(ResponseCode.METHOD_NOT_ALLOWED);
	}

	class UpdateResource extends CoapResource {

		public UpdateResource(String name) {
			super(name);
		}

		@Override
		public void handlePUT(CoapExchange exchange) {
			update(exchange);
		}
	}
}
