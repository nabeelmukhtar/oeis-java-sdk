package org.oeis.api.services.impl;

import java.io.BufferedReader;
import java.io.Reader;

import org.oeis.api.common.PagedArrayList;
import org.oeis.api.common.PagedList;
import org.oeis.api.services.OeisException;

public class OeisParser {

	public <T> PagedList<T> parse(Reader reader) {
		PagedList<T> retValue = new PagedArrayList<T>();
		try {
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while ((line = br.readLine()) != null) {
				
			}
		} catch (Exception e) {
			throw new OeisException(e);
		}
		return retValue;
	}
}
