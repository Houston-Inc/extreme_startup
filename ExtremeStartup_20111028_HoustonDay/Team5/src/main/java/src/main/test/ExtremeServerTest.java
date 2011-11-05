package src.main.test;

import org.junit.Assert;
import org.junit.Test;

import com.houston.extreme.ExtremeServer;

public class ExtremeServerTest {

	@Test
	public void testGetLargest() {
		ExtremeServer server = new ExtremeServer();

		String result = server
				.get("57cb2ef0: which of the following numbers is the largest: 22, 720, 16, 945");

		Assert.assertEquals("945", result);
	}

	@Test
	public void testGetPlus() {
		ExtremeServer server = new ExtremeServer();

		String result = server.get("57cb2ef0: what is 18 plus 13");

		Assert.assertEquals("31", result);
	}


	@Test
	public void testGetMultiply() {
		ExtremeServer server = new ExtremeServer();

		String result = server.get("57c89800: what is 19 multiplied by 10");

		Assert.assertEquals("190", result);
	}

	@Test
	public void testGetSquareCudeReturnsEmpty() {
		ExtremeServer server = new ExtremeServer();

		String result = server
				.get("3facef10: which of the following numbers is both a square and a cube: 2025, 225, 444, 849");

		Assert.assertEquals("", result);
	}

	@Test
	public void testGetSquareCude() {
		ExtremeServer server = new ExtremeServer();

		String result = server
				.get("36b129b0: which of the following numbers is both a square and a cube: 15625, 81, 46656, 165");

		Assert.assertEquals("15625", result);
	}

	@Test
	public void testGetWhere() {
		ExtremeServer server = new ExtremeServer();

		String result = server.get("where do you work");

		Assert.assertEquals("Houston Inc.", result);
	}

	@Test
	public void testGetWho() {
		ExtremeServer server = new ExtremeServer();

		String result = server.get("who is your BOSS");

		Assert.assertEquals("Tomi Ruotimo", result);
	}

	@Test
	public void testGetPrimes() {
		ExtremeServer server = new ExtremeServer();

		String result = server
				.get("6131d100: which of the following numbers are primes: 347, 61, 310, 239");

		Assert.assertEquals("347,61,239", result);
	}

	@Test
	public void testGetMinus() {
		ExtremeServer server = new ExtremeServer();


		Assert.assertEquals("-17", server.get("6131d100: what is 0 minus 17"));
		Assert.assertEquals("-4", server.get("6131d100: what is 9 minus 13"));
	}

	@Test
	public void testGetFibonacci() {
		ExtremeServer server = new ExtremeServer();

		String result = server
				.get("f0ef4a80: what is the 5th number in the Fibonacci sequence");

		Assert.assertEquals("5", result);
	}

	@Test
	public void testGetPower() {
		ExtremeServer server = new ExtremeServer();

		String result = server.get("f0ef4a80: what is 3 to the power of 2");

		Assert.assertEquals("9", result);
	}

	@Test
	public void testGetMultiplyPlus() {
		ExtremeServer server = new ExtremeServer();

		String result = server
				.get("90956a90: what is 13 multiplied by 7 plus 13");

		Assert.assertEquals("104", result);
	}

}
