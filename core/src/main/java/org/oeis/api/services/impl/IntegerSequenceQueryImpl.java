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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.oeis.api.common.PagedList;
import org.oeis.api.schema.IntegerSequence;
import org.oeis.api.schema.Keyword;
import org.oeis.api.schema.Order;
import org.oeis.api.services.IntegerSequenceQuery;
import org.oeis.api.services.OeisException;
import org.oeis.api.services.constant.OeisApiUrls;
import org.oeis.api.services.constant.ParameterNames;

/**
 * The Class IntegerSequenceQueryImpl.
 */
public class IntegerSequenceQueryImpl extends BaseOeisQuery<IntegerSequence> implements
	IntegerSequenceQuery {
	
    /** The parser. */
    private final OeisParser parser = new OeisParser();
    
	/** The query builder. */
	StringBuilder queryBuilder = new StringBuilder();

	/* (non-Javadoc)
	 * @see org.worldbank.api.services.WorldBankQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createOeisApiUrlBuilder(OeisApiUrls.SEARCH_URL);
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withAuthor(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withAuthor(String author) {
		queryBuilder.append(ParameterNames.AUTHOR).append(author).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withIds(java.lang.String[])
	 */
	@Override
	public IntegerSequenceQuery withIds(String... ids) {
		for (int i = 0; i < ids.length; i++) {
			queryBuilder.append(ParameterNames.ID).append(ids[i]);
			if (i != (ids.length - 1)) {
				queryBuilder.append("|");				
			} else {
				queryBuilder.append(" ");
			}
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withKeywords(org.oeis.api.schema.Keyword[])
	 */
	@Override
	public IntegerSequenceQuery withKeywords(Keyword... keywords) {
		for (int i = 0; i < keywords.length; i++) {
			queryBuilder.append(ParameterNames.KEYWORD).append(keywords[i].value()).append(" ");
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withOrderedTerms(int[])
	 */
	@Override
	public IntegerSequenceQuery withOrderedTerms(long... terms) {
		for (int i = 0; i < terms.length; i++) {
			queryBuilder.append(terms[i]);
			if (i != terms.length - 1) {
				queryBuilder.append(",");
			} else {
				queryBuilder.append(" ");
			}
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withQuery(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withQuery(String query) {
		queryBuilder.append(query).append(" ");
		return this;
	}
	
	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withTerms(int[])
	 */
	@Override
	public IntegerSequenceQuery withTerms(long... terms) {
		for (int i = 0; i < terms.length; i++) {
			queryBuilder.append(terms[i]).append(" ");
		}
		return this;
	}
	
	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withOutKeywords(org.oeis.api.schema.Keyword[])
	 */
	@Override
	public IntegerSequenceQuery withOutKeywords(Keyword... keywords) {
		for (int i = 0; i < keywords.length; i++) {
			queryBuilder.append("-").append(ParameterNames.KEYWORD).append(keywords[i].value()).append(" ");
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withOutTerms(long[])
	 */
	@Override
	public IntegerSequenceQuery withOutTerms(long... terms) {
		for (int i = 0; i < terms.length; i++) {
			queryBuilder.append("~").append(terms[i]).append(" ");
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withAnyKeyword(org.oeis.api.schema.Keyword[])
	 */
	@Override
	public IntegerSequenceQuery withAnyKeyword(Keyword... keywords) {
		for (int i = 0; i < keywords.length; i++) {
			queryBuilder.append(ParameterNames.KEYWORD).append(keywords[i].value());
			if (i != (keywords.length - 1)) {
				queryBuilder.append("|");				
			} else {
				queryBuilder.append(" ");
			}
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withComment(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withComment(String comment) {
		queryBuilder.append(ParameterNames.COMMENT).append(comment).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withExample(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withExample(String example) {
		queryBuilder.append(ParameterNames.EXAMPLE).append(example).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withExtension(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withExtension(String extension) {
		queryBuilder.append(ParameterNames.EXTENSION).append(extension).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withFormula(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withFormula(String formula) {
		queryBuilder.append(ParameterNames.FORMULA).append(formula).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withLink(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withLink(String link) {
		queryBuilder.append(ParameterNames.LINK).append(link).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withMapleProgram(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withMapleProgram(String maple) {
		queryBuilder.append(ParameterNames.MAPLE).append(maple).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withMathematicaProgram(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withMathematicaProgram(String mathematica) {
		queryBuilder.append(ParameterNames.MATHEMATICA).append(mathematica).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withName(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withName(String name) {
		queryBuilder.append(ParameterNames.NAME).append(name).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withOtherProgram(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withOtherProgram(String program) {
		queryBuilder.append(ParameterNames.PROGRAM).append(program).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withReference(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withReference(String ref) {
		queryBuilder.append(ParameterNames.REF).append(ref).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withXref(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withXref(String xref) {
		queryBuilder.append(ParameterNames.XREF).append(xref).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withSort(org.oeis.api.schema.Order)
	 */
	@Override
	public IntegerSequenceQuery withSort(Order sort) {
		apiUrlBuilder.withParameter(ParameterNames.SORT, sort.value());
		return this;
	}
	
	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withCount(int)
	 */
	@Override
	public IntegerSequenceQuery withCount(int count) {
		apiUrlBuilder.withParameter(ParameterNames.COUNT, String.valueOf(count));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withStart(int)
	 */
	@Override
	public IntegerSequenceQuery withStart(int start) {
		apiUrlBuilder.withParameter(ParameterNames.START, String.valueOf(start));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withRandom(int)
	 */
	@Override
	public IntegerSequenceQuery withRandom(int random) {
		apiUrlBuilder.withParameter(ParameterNames.RANDOM, String.valueOf(random));
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PagedList<IntegerSequence> list() {
		InputStream is = null;
        try {
    		apiUrlBuilder.withParameter(ParameterNames.QUERY, queryBuilder.toString().trim());
        	is = callApiGet(apiUrlBuilder.buildUrl());
        	PagedList<IntegerSequence> responseList = parser.parse(new InputStreamReader(is, UTF_8_CHAR_SET));
			return responseList;
        } catch (Exception e) {
            throw new OeisException(e);
        } finally {
	        closeStream(is);
	    }
	}
	
	/* (non-Javadoc)
	 * @see org.worldbank.api.services.WorldBankQuery#singleResult()
	 */
	@Override
	public IntegerSequence singleResult() {
		List<IntegerSequence> list = list();
		return (list.isEmpty())? null : list.get(0);
	}
}
