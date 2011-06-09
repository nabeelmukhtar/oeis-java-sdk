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
import java.util.HashMap;
import java.util.Map;

import org.oeis.api.common.PagedArrayList;
import org.oeis.api.common.PagedList;
import org.oeis.api.services.OeisException;
import org.oeis.api.services.SequenceMusicQuery;
import org.oeis.api.services.constant.OeisApiUrls;
import org.oeis.api.services.constant.ParameterNames;

/**
 * The Class SequenceMusicQueryImpl.
 */
public class SequenceMusicQueryImpl extends BaseOeisQuery<InputStream> implements
		SequenceMusicQuery {
	
	/** The parameters. */
	private Map<String, String> parameters;

	/* (non-Javadoc)
	 * @see org.oeis.api.services.OeisQuery#list()
	 */
	@Override
	public PagedList<InputStream> list() {
		PagedList<InputStream> list = new PagedArrayList<InputStream>();
		list.add(singleResult());
		return list;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.OeisQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createOeisApiUrlBuilder(OeisApiUrls.PLAY_URL);
		parameters = new HashMap<String, String>();
		parameters.put(ParameterNames.MIDI, "1");
		parameters.put(ParameterNames.PLAY, "PLAY");
		parameters.put(ParameterNames.RATE, "100");
		parameters.put(ParameterNames.VOLUME, "100");
		parameters.put(ParameterNames.VOICE, "1");
		parameters.put(ParameterNames.ATTACK_VELOCITY, "80");
		parameters.put(ParameterNames.RELEASE_VELOCITY, "80");
		parameters.put(ParameterNames.PITCH_MODULUS, "88");
		parameters.put(ParameterNames.PITCH_OFFSET, "20");
		parameters.put(ParameterNames.DURATION_MODULUS, "1");
		parameters.put(ParameterNames.DURATION_OFFSET, "0");
		parameters.put(ParameterNames.SEQUENCE_CUTOFF, "4096");
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.OeisQuery#singleResult()
	 */
	@Override
	public InputStream singleResult() {
        try {
        	return callApiPost(apiUrlBuilder.buildUrl(), parameters);
        } catch (Exception e) {
            throw new OeisException(e);
        }
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withSequenceId(java.lang.String)
	 */
	@Override
	public SequenceMusicQuery withSequenceId(String sequenceId) {
		parameters.put(ParameterNames.SEQUENCE, sequenceId);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withAttackVelocity(int)
	 */
	@Override
	public SequenceMusicQuery withAttackVelocity(int attackVelocity) {
		parameters.put(ParameterNames.ATTACK_VELOCITY, String.valueOf(attackVelocity));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withDurationModulus(int)
	 */
	@Override
	public SequenceMusicQuery withDurationModulus(int durationModulus) {
		parameters.put(ParameterNames.DURATION_MODULUS, String.valueOf(durationModulus));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withDurationOffset(int)
	 */
	@Override
	public SequenceMusicQuery withDurationOffset(int durationOffset) {
		parameters.put(ParameterNames.DURATION_OFFSET, String.valueOf(durationOffset));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withInstrument(org.oeis.api.services.SequenceMusicQuery.Instrument)
	 */
	@Override
	public SequenceMusicQuery withInstrument(Instrument instrument) {
		parameters.put(ParameterNames.VOICE, String.valueOf(instrument.id()));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withPitchModulus(int)
	 */
	@Override
	public SequenceMusicQuery withPitchModulus(int pitchModulus) {
		parameters.put(ParameterNames.PITCH_MODULUS, String.valueOf(pitchModulus));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withPitchOffset(int)
	 */
	@Override
	public SequenceMusicQuery withPitchOffset(int pitchOffset) {
		parameters.put(ParameterNames.PITCH_OFFSET, String.valueOf(pitchOffset));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withRate(int)
	 */
	@Override
	public SequenceMusicQuery withRate(int rate) {
		parameters.put(ParameterNames.RATE, String.valueOf(rate));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withReleaseVelocity(int)
	 */
	@Override
	public SequenceMusicQuery withReleaseVelocity(int releaseVelocity) {
		parameters.put(ParameterNames.RELEASE_VELOCITY, String.valueOf(releaseVelocity));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withSequenceCuttoff(long)
	 */
	@Override
	public SequenceMusicQuery withSequenceCutoff(long sequenceCutoff) {
		parameters.put(ParameterNames.SEQUENCE_CUTOFF, String.valueOf(sequenceCutoff));
		return this;
	}

	/* (non-Javadoc)
	 * @see org.oeis.api.services.SequenceMusicQuery#withVolume(int)
	 */
	@Override
	public SequenceMusicQuery withVolume(int volume) {
		parameters.put(ParameterNames.VOLUME, String.valueOf(volume));
		return this;
	}

}
