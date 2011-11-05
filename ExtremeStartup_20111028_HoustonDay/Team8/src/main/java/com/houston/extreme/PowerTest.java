package com.houston.extreme;

import junit.framework.Assert;

import org.junit.Test;

public class PowerTest {

	@Test
	public void powertest() throws Exception {

		PowerAnswer powerAnswer = new PowerAnswer();
		Assert.assertEquals("4",
				powerAnswer.answer("what is 2 to the power of 2"));

	}

}
