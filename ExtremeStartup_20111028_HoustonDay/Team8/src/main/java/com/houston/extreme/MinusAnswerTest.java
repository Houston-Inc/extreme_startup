package com.houston.extreme;

import junit.framework.Assert;

import org.junit.Test;

public class MinusAnswerTest {

	@Test
	public void testName() throws Exception {
		MinusAnswer minusAnswer = new MinusAnswer();
		Assert.assertEquals("9", minusAnswer.answer("what is 14 minus 5"));

	}
}
