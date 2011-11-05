package com.houston.extreme;

import junit.framework.Assert;

import org.junit.Test;

public class SquareCubeTest {

	@Test
	public void testSquareCube() throws Exception {
		// which of the following numbers is both a square and a cube: 559, 400,
		// 537, 1681
		SquareCubeAnswer answer = new SquareCubeAnswer();
		Assert.assertEquals(
				"15625",
				answer.answer("which of the following numbers is both a square and a cube: 15625"));

		Assert.assertEquals(
				"",
				answer.answer("which of the following numbers is both a square and a cube: 676, 311, 262144, 208"));

	}
}
