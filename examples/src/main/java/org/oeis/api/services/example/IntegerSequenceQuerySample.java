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
package org.oeis.api.services.example;

import java.io.InputStream;
import java.util.List;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import org.oeis.api.schema.IntegerSequence;
import org.oeis.api.services.IntegerSequenceQuery;
import org.oeis.api.services.OeisQueryFactory;
import org.oeis.api.services.SequenceMusicQuery;


/**
 * The Class IntegerSequenceQuerySample.
 */
public class IntegerSequenceQuerySample {

    /**
     * The main method.
     * 
     * @param args the arguments
     * 
     * @throws Exception the exception
     */
	public static void main(String[] args) throws Exception {
		OeisQueryFactory factory = OeisQueryFactory.newInstance();
		IntegerSequenceQuery service = factory.createIntegerSequenceQuery();
		List<IntegerSequence> sequences = service.withOrderedTerms(1,1,2,3,5,8).list();
		for (IntegerSequence sequence : sequences) {
			printResult(sequence);
		}
		InputStream is = null;
		try {
			SequenceMusicQuery music = factory.createSequenceMusicQuery();
			is = music.withSequenceId("A000142").singleResult();
			playMusic(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			is.close();
		}
	}

	/**
	 * Prints the result.
	 * 
	 * @param sequence the sequence
	 */
	private static void printResult(IntegerSequence sequence) {
		System.out.println(sequence.getCatalogNumber() + ":" + sequence.getIdentification() + ":" + sequence.getName());
	}
	
	/**
	 * Play music.
	 * 
	 * @param is the is
	 * 
	 * @throws Exception the exception
	 */
	private static void playMusic(InputStream is) throws Exception {
        // From file
        Sequence sequence = MidiSystem.getSequence(is);
    
        // Create a sequencer for the sequence
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(sequence);
    
        // Start playing
        sequencer.start();
	}
}
