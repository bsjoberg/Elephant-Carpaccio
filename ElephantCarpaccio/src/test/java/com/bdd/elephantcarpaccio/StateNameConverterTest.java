package com.bdd.elephantcarpaccio;

import org.junit.Test;

import com.bdd.elephantcarpaccio.StateNameConverter;

import junit.framework.TestCase;

public class StateNameConverterTest extends TestCase {

	@Test
	public void testConvertUtahNameToCode ()
	{
		String stateCode = StateNameConverter.convertStateName("Utah"); 
		assertEquals("UT", stateCode);
	}

	@Test
	public void testConvertFloridaNameToCode ()
	{
		String stateCode = StateNameConverter.convertStateName("Nevada");
		assertEquals("NV", stateCode);
	}
}
