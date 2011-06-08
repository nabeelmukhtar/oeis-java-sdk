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
import org.oeis.api.schema.Order;



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
	public IntegerSequenceQuery withOrderedTerms(long... terms);
	
	/**
	 * With terms.
	 * 
	 * @param terms the terms
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withTerms(long... terms);
	
	/**
	 * With out terms.
	 * 
	 * @param terms the terms
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withOutTerms(long... terms);
	
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
	 * With any keyword.
	 * 
	 * @param keywords the keywords
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withAnyKeyword(Keyword... keywords);
	
	/**
	 * With out keywords.
	 * 
	 * @param keywords the keywords
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withOutKeywords(Keyword... keywords);
	
	/**
	 * With ids.
	 * 
	 * @param ids the ids
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withIds(String... ids);
	
	/**
	 * With comment.
	 * 
	 * @param comment the comment
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withComment(String comment);
	
	/**
	 * With reference.
	 * 
	 * @param ref the ref
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withReference(String ref);
	
	/**
	 * With link.
	 * 
	 * @param link the link
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withLink(String link);
	
	/**
	 * With formula.
	 * 
	 * @param formula the formula
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withFormula(String formula);
	
	/**
	 * With name.
	 * 
	 * @param name the name
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withName(String name);
	
	/**
	 * With example.
	 * 
	 * @param example the example
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withExample(String example);
	
	/**
	 * With maple program.
	 * 
	 * @param maple the maple
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withMapleProgram(String maple);
	
	/**
	 * With mathematica program.
	 * 
	 * @param mathematica the mathematica
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withMathematicaProgram(String mathematica);
	
	/**
	 * With other program.
	 * 
	 * @param program the program
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withOtherProgram(String program);
	
	/**
	 * With xref.
	 * 
	 * @param xref the xref
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withXref(String xref);
	
	/**
	 * With extension.
	 * 
	 * @param extension the extension
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withExtension(String extension);
	
	/**
	 * With sort.
	 * 
	 * @param sort the sort
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withSort(Order sort);
	
	/**
	 * With count.
	 * 
	 * @param count the count
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withCount(int count);
	
	/**
	 * With start.
	 * 
	 * @param start the start
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withStart(int start);
	
	/**
	 * With random.
	 * 
	 * @param random the random
	 * 
	 * @return the integer sequence query
	 */
	public IntegerSequenceQuery withRandom(int random);
}
