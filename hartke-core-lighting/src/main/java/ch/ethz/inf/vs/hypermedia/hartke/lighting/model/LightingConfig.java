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
package ch.ethz.inf.vs.hypermedia.hartke.lighting.model;

import ch.ethz.inf.vs.hypermedia.client.MediaType;

/**
 * Created by ynh on 25/09/15.
 */
@MediaType(contentType = 65202, mediaType = "application/lighting-config+json")
public class LightingConfig extends CoREAppBase {

	private Link src;

	public Link getSrc() {
		return src;
	}

	public void setSrc(Link src) {
		this.src = src;
	}
}
