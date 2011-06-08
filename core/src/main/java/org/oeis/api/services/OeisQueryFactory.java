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
package org.oeis.api.services;

import org.oeis.api.services.impl.IntegerSequenceQueryImpl;
import org.oeis.api.services.impl.SequenceMusicQueryImpl;




/**
 * A factory for creating OeisQuery objects.
 */
public class OeisQueryFactory {

    /**
     * Instantiates a new oeis query factory.
     */
	private OeisQueryFactory() {
    }
	
    /**
     * New instance.
     * 
     * @return the oeis query factory
     */
    public static OeisQueryFactory newInstance() {
        return new OeisQueryFactory();
    }
    
    /**
     * Creates a new OeisQuery object.
     * 
     * @return the integer sequence query
     */
    public IntegerSequenceQuery createIntegerSequenceQuery() {
    	return new IntegerSequenceQueryImpl();
    }
    
    /**
     * Creates a new OeisQuery object.
     * 
     * @return the sequence music query
     */
    public SequenceMusicQuery createSequenceMusicQuery() {
    	return new SequenceMusicQueryImpl();
    }
}
