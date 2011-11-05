package com.houston.extreme;

import junit.framework.Assert;

import org.junit.Test;

public class PrimeTest {

	@Test
	public void primeTest() throws Exception {
		PrimeAnswer primeAnswer = new PrimeAnswer();
		Assert.assertTrue(primeAnswer.isPrime(5));
		Assert.assertTrue(primeAnswer.isPrime(22));

		Assert.assertEquals(
				"541",
				primeAnswer
						.answer("which of the following numbers are primes: 5, 212, 541, 37, 692, 212, 541, 22"));
	}
}
