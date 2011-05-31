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
 * The Enum Keyword.
 */
public enum Keyword implements ValueEnum {
	
	/** The BASE. */
	BASE("base"),
	
	/** The BREF. */
	BREF("bref"),
	
	/** The COFR. */
	COFR("cofr"),
	
	/** The CONS. */
	CONS("cons"),
	
	/** The CORE. */
	CORE("core"),
	
	/** The DEAD. */
	DEAD("dead"),
	
	/** The DUMB. */
	DUMB("dumb"),
	
	/** The DUPE. */
	DUPE("dupe"),
	
	/** The EASY. */
	EASY("easy"),
	
	/** The EIGEN. */
	EIGEN("eigen"),
	
	/** The FINI. */
	FINI("fini"),
	
	/** The FRAC. */
	FRAC("frac"),
	
	/** The FULL. */
	FULL("full"),
	
	/** The HARD. */
	HARD("hard"),
	
	/** The LESS. */
	LESS("less"),
	
	/** The MORE. */
	MORE("more"),
	
	/** The MULT. */
	MULT("mult"),
	
	/** The NEW. */
	NEW("new"),
	
	/** The NICE. */
	NICE("nice"),
	
	/** The NONN. */
	NONN("nonn"),
	
	/** The OBSC. */
	OBSC("obsc"),
	
	/** The SIGN. */
	SIGN("sign"),
	
	/** The TABF. */
	TABF("tabf"),
	
	/** The TABL. */
	TABL("tabl"),
	
	/** The UNED. */
	UNED("uned"),
	
	/** The UNKN. */
	UNKN("unkn"),
	
	/** The WALK. */
	WALK("walk"),
	
	/** The WORD. */
	WORD("word");
	
	
    /** The Constant stringToEnum. */
	private static final Map<String, Keyword> stringToEnum = new HashMap<String, Keyword>();

	static { // Initialize map from constant name to enum constant
		for (Keyword op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new keyword.
     * 
     * @param value the value
     */
    Keyword(String value) {
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
	 * @return the keyword
	 */
	public static Keyword fromValue(String value) {
		return stringToEnum.get(value);
	}

}
