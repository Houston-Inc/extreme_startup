package com.houston.extreme;

import junit.framework.Assert;

import org.junit.Test;

public class RegExpTest {

	@Test
	public void testPlusExp() {
		PlusAnswer answer = new PlusAnswer();
		Assert.assertTrue(answer.canAnswer("what is 13 plus 1"));

	}

	@Test
	public void testsum() throws Exception {
		PlusAnswer answer = new PlusAnswer();
		Assert.assertEquals("14", answer.answer("what is 13 plus 1"));
	}

}
