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

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.oeis.api.common.PagedArrayList;
import org.oeis.api.common.PagedList;
import org.oeis.api.schema.IntegerSequence;
import org.oeis.api.schema.Keyword;
import org.oeis.api.schema.IntegerSequence.Offset;
import org.oeis.api.services.OeisException;
import org.oeis.api.services.constant.ApplicationConstants;

/**
 * The Class OeisParser.
 */
public class OeisParser {

	/**
	 * Parses the.
	 * 
	 * @param reader the reader
	 * 
	 * @return the paged list< integer sequence>
	 */
	public PagedList<IntegerSequence> parse(Reader reader) {
		Pattern pattern = ApplicationConstants.SEQUENCE_PATTERN;
		PagedList<IntegerSequence> retValue = new PagedArrayList<IntegerSequence>();
		Map<String, IntegerSequence> sequenceMap = new HashMap<String, IntegerSequence>();
		try {
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while ((line = br.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches()) {
					String identification = matcher.group(2);
					IntegerSequence sequence = sequenceMap.get(identification);
					if (sequence == null) {
						sequence = new IntegerSequence();
						sequence.setIdentification(identification);
						sequence.setCatalogNumber(identification);
						sequenceMap.put(identification, sequence);
					}
					setSequenceValue(sequence, matcher.group(1), matcher.group(3));
				}
			}
		} catch (Exception e) {
			throw new OeisException(e);
		}
		retValue.addAll(sequenceMap.values());
		return retValue;
	}

	/**
	 * Sets the sequence value.
	 * 
	 * @param sequence the sequence
	 * @param type the type
	 * @param value the value
	 */
	private void setSequenceValue(IntegerSequence sequence, String type, String value) {
		switch (type.charAt(0)) {
		case 'I':
			sequence.setIdentification(value);
			
			break;
		case 'S':
		case 'T':
		case 'U':
			sequence.getAbsoluteTerms().addAll(parseIntegerArray(value));

			break;
		case 'V':
		case 'W':
		case 'X':
			sequence.getSignedTerms().addAll(parseIntegerArray(value));
			
			break;
		case 'N':
			sequence.setName(value);
			
			break;
		case 'D':
			sequence.getDetailedReferences().add(value);
			
			break;
		case 'H':
			sequence.getLinks().add(value);
			
			break;
		case 'F':
			sequence.getFormulas().add(value);
			
			break;
		case 'Y':
			sequence.getCrossReferences().add(value);
			
			break;
		case 'A':
			sequence.setAuthor(value);
			
			break;
		case 'O':
			sequence.setOffset(parseOffset(value));
			
			break;
		case 'p':
			sequence.getMapleProgram().add(value);
			
			break;
		case 't':
			sequence.getMathematicaProgram().add(value);
			
			break;
		case 'o':
			sequence.getOtherProgram().add(value);
			
			break;
		case 'E':
			sequence.getExtendsionsAndErrors().add(value);
			
			break;
		case 'e':
			sequence.getExamples().add(value);
			
			break;
		case 'K':
			sequence.getKeywords().addAll(parseKeywords(value));
			
			break;
		case 'C':
			sequence.getComments().add(value);
			
			break;
		default:
			break;
		}
	}

	/**
	 * Parses the keywords.
	 * 
	 * @param value the value
	 * 
	 * @return the list< keyword>
	 */
	private List<Keyword> parseKeywords(String value) {
		String[] tokens = value.split(",");
		List<Keyword>  keywords = new ArrayList<Keyword>(tokens.length);
		for (int i = 0; i < tokens.length; i++) {
			keywords.add(Keyword.fromValue(tokens[i]));
		}
		return keywords;
	}

	/**
	 * Parses the offset.
	 * 
	 * @param value the value
	 * 
	 * @return the offset
	 */
	private Offset parseOffset(String value) {
		String[] tokens = value.split(",");
		return new Offset(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
	}

	/**
	 * Parses the integer array.
	 * 
	 * @param value the value
	 * 
	 * @return the list< integer>
	 */
	private List<Long> parseIntegerArray(String value) {
		String[] tokens = value.split(",");
		List<Long>  integers = new ArrayList<Long>(tokens.length);
		for (int i = 0; i < tokens.length; i++) {
			integers.add(Long.parseLong(tokens[i]));
		}
		return integers;
	}
}
