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

import java.io.InputStream;



/**
 * The Interface SequenceMusicQuery.
 */
public interface SequenceMusicQuery extends OeisQuery<InputStream> {
	
	/**
	 * The Enum Instrument.
	 */
	public enum Instrument {
		
		/** The ACOUSTI c_ gran d_ piano. */
		ACOUSTIC_GRAND_PIANO(1, "Acoustic Grand Piano");
		
		/** The id. */
		private final int id;
		
		/** The value. */
		private final String value;
		
		/**
		 * Instantiates a new instrument.
		 * 
		 * @param id the id
		 * @param value the value
		 */
		Instrument(int id, String value) {
			this.id= id;
			this.value = value;
		}
		
		/**
		 * Id.
		 * 
		 * @return the int
		 */
		public int id() {
			return id;
		}
		
		/**
		 * Value.
		 * 
		 * @return the string
		 */
		public String value() {
			return value;
		}
	}
	
	/**
	 * With sequence id.
	 * 
	 * @param sequenceId the sequence id
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withSequenceId(String sequenceId);
	
	/**
	 * With rate.
	 * 
	 * @param rate the rate
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withRate(int rate);
	
	/**
	 * With volume.
	 * 
	 * @param volume the volume
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withVolume (int volume);
	
	/**
	 * With instrument.
	 * 
	 * @param instrument the instrument
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withInstrument(Instrument instrument);
	
	/**
	 * With attack velocity.
	 * 
	 * @param attackVelocity the attack velocity
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withAttackVelocity(int attackVelocity);
	
	/**
	 * With release velocity.
	 * 
	 * @param releaseVelocity the release velocity
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withReleaseVelocity(int releaseVelocity);
	
	/**
	 * With pitch modulus.
	 * 
	 * @param pitchModulus the pitch modulus
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withPitchModulus(int pitchModulus);
	
	/**
	 * With pitch offset.
	 * 
	 * @param pitchOffset the pitch offset
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withPitchOffset(int pitchOffset);
	
	/**
	 * With duration modulus.
	 * 
	 * @param durationModulus the duration modulus
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withDurationModulus(int durationModulus);
	
	/**
	 * With duration offset.
	 * 
	 * @param durationOffset the duration offset
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withDurationOffset(int durationOffset);
	
	/**
	 * With sequence cuttoff.
	 * 
	 * @param sequenceCutoff the sequence cutoff
	 * 
	 * @return the sequence music query
	 */
	public SequenceMusicQuery withSequenceCuttoff(long sequenceCutoff);
	
	public String buildUrl();
}
