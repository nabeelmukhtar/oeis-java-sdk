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
package org.oeis.api.schema;

import java.util.HashMap;
import java.util.Map;

import org.oeis.api.common.ValueEnum;

/**
 * The Enum Order.
 */
public enum Order implements ValueEnum {
	
	/** The RELEVANCE. */
	RELEVANCE(""),
	
	/** The REFERENCES. */
	REFERENCES("references"),
	
	/** The NUMBER. */
	NUMBER("number"),
	
	/** The MODIFIED. */
	MODIFIED("modified"),
	
	/** The CREATED. */
	CREATED("created");
	
	
    /** The Constant stringToEnum. */
	private static final Map<String, Order> stringToEnum = new HashMap<String, Order>();

	static { // Initialize map from constant name to enum constant
		for (Order op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new order.
     * 
     * @param value the value
     */
    Order(String value) {
        this.value = value;
    }

	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.common.ValueEnum#value()
	 */
	@Override
	public String value() {
		return value;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the order
	 */
	public static Order fromValue(String value) {
		return stringToEnum.get(value);
	}

}
