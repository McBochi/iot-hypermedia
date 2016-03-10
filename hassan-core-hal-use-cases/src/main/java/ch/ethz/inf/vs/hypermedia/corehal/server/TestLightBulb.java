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
 *******************************************************************************/
package ch.ethz.inf.vs.hypermedia.corehal.server;

import ch.ethz.inf.vs.hypermedia.client.HypermediaClient;
import ch.ethz.inf.vs.hypermedia.corehal.block.LightingStateFuture;
import ch.ethz.inf.vs.hypermedia.corehal.block.ThingCrawler;
import ch.ethz.inf.vs.hypermedia.corehal.block.ThingDescriptionFuture;

import java.util.concurrent.ExecutionException;

/**
 * Created by ynh on 20/11/15.
 */
public class TestLightBulb {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		HypermediaClient client = new HypermediaClient("coap://localhost:5783/");
		ThingDescriptionFuture thingdescription = client.resources().use(new ThingCrawler())
				.withLocationName("/CH/ETH/CAB/51")
				.findFirstWithLink("lighting-state");

		LightingStateFuture lightstate = thingdescription.follow("lighting-state", LightingStateFuture::new);

		while (true) {
			try {
				System.err.println("---Set color");
				lightstate.setHSV((int) (360 * Math.random()), 1, 1);
			} catch (ExecutionException e) {
				System.err.println("---FAILED");
			}

			Thread.sleep(3000);
		}
	}
}