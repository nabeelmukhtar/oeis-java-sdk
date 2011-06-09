/*
 * Copyright 2010-2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package org.oeis.api.services.impl;

import java.nio.charset.Charset;

import org.oeis.api.services.OeisQuery;
import org.oeis.api.services.constant.ApplicationConstants;
import org.oeis.api.services.constant.OeisApiUrls.OeisApiUrlBuilder;

/**
 * The Class BaseOeisQuery.
 */
public abstract class BaseOeisQuery<E> extends OeisApiGateway implements OeisQuery<E> {
	
	/** The Constant UTF_8_CHAR_SET. */
	protected static final Charset UTF_8_CHAR_SET = Charset.forName(ApplicationConstants.CONTENT_ENCODING);
	
	/** The api url builder. */
	protected OeisApiUrlBuilder apiUrlBuilder;
    
	/**
	 * Instantiates a new base oeis query.
	 */
	public BaseOeisQuery() {
        // by default we compress contents
        requestHeaders.put("Accept-Encoding", "gzip, deflate");
        reset();
	}

	/**
	 * Instantiates a new base oeis query.
	 * 
	 * @param apiVersion the api version
	 */
	public BaseOeisQuery(String apiVersion) {
		setApiVersion(apiVersion);
	}
	
	/**
	 * Creates the oeis api url builder.
	 * 
	 * @param urlFormat the url format
	 * 
	 * @return the oeis api url builder
	 */
	protected OeisApiUrlBuilder createOeisApiUrlBuilder(String urlFormat) {
		return new OeisApiUrlBuilder(urlFormat);
	}
}
