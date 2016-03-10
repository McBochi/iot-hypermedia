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
package ch.ethz.inf.vs.hypermedia.client.utils;

/**
 * Created by ynh on 07/12/15.
 */
public abstract class PostOrderCrawler<B> extends DFSCrawler<B> {

	public PostOrderCrawler(Iterable<B> start) {
		super(start);
		setPostOrder(true);
	}

	public PostOrderCrawler(B start) {
		super(start);
		setPostOrder(true);
	}
}
