package com.houston.extreme;

import junit.framework.Assert;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void fibonacci() throws Exception {

		FibonacciAnswer answer = new FibonacciAnswer();

		Assert.assertEquals(3, answer.fib(4));
		Assert.assertTrue(answer
				.canAnswer("what is the 5th number in the Fibonacci sequence"));
		Assert.assertEquals("3", answer
				.answer("what is the 4th number in the Fibonacci sequence"));
	}

}
