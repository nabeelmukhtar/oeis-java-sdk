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

import org.oeis.api.schema.IntegerSequence;
import org.oeis.api.schema.Keyword;



/**
 * The Interface IntegerSequenceQuery.
 */
public interface IntegerSequenceQuery extends OeisQuery<IntegerSequence> {
	
	/**
	 * With query.
	 * 
	 * @param query the query
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withQuery(String query);
	
	/**
	 * With ordered terms.
	 * 
	 * @param terms the terms
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withOrderedTerms(int... terms);
	
	/**
	 * With terms.
	 * 
	 * @param terms the terms
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withTerms(int... terms);
	
	/**
	 * With author.
	 * 
	 * @param author the author
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withAuthor(String author);
	
	/**
	 * With keywords.
	 * 
	 * @param keywords the keywords
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withKeywords(Keyword... keywords);
	
	/**
	 * With ids.
	 * 
	 * @param ids the ids
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withIds(String... ids);
}
