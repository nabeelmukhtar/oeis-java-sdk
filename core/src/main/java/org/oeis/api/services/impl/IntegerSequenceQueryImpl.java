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

import org.oeis.api.common.PagedList;
import org.oeis.api.schema.IntegerSequence;
import org.oeis.api.schema.Keyword;
import org.oeis.api.services.IntegerSequenceQuery;
import org.oeis.api.services.constant.OeisApiUrls;

/**
 * The Class IntegerSequenceQueryImpl.
 */
public class IntegerSequenceQueryImpl extends BaseOeisQuery<IntegerSequence> implements
	IntegerSequenceQuery {
	
	/** The query builder. */
	StringBuilder queryBuilder = new StringBuilder();

	/* (non-Javadoc)
	 * @see org.worldbank.api.services.WorldBankQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createOeisApiUrlBuilder(OeisApiUrls.SEARCH_URL);
		apiUrlBuilder.withParameter("fmt", "text");
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withAuthor(java.lang.String)
	 */
	@Override
	public IntegerSequenceQuery withAuthor(String author) {
		queryBuilder.append("author:").append(author).append(" ");
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withIds(java.lang.String[])
	 */
	@Override
	public IntegerSequenceQuery withIds(String... ids) {
		for (int i = 0; i < ids.length; i++) {
			queryBuilder.append("id:").append(ids[i]).append(" ");
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withKeywords(org.oeis.api.schema.Keyword[])
	 */
	@Override
	public IntegerSequenceQuery withKeywords(Keyword... keywords) {
		for (int i = 0; i < keywords.length; i++) {
			queryBuilder.append("keyword:").append(keywords[i].value()).append(" ");
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.IntegerSequenceQuery#withOrderedTerms(int[])
	 */
	@Override
	public IntegerSequenceQuery withOrderedTerms(int... terms) {
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
	public IntegerSequenceQuery withTerms(int... terms) {
		for (int i = 0; i < terms.length; i++) {
			queryBuilder.append(terms[i]).append(" ");
		}
		return this;
	}
	
	/* (non-Javadoc)
	 * @see org.oeis.api.services.impl.BaseOeisQuery#list()
	 */
	@Override
	public PagedList<IntegerSequence> list() {
		apiUrlBuilder.withParameter("q", queryBuilder.toString().trim());
		return super.list();
	}
}
