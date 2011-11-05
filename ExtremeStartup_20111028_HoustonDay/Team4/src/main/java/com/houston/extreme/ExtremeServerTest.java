package com.houston.extreme;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExtremeServerTest {

	@Test
	public void test() {
		double cc = 1;
		System.out.println( Math.cbrt(cc));
		System.out.println(Math.sqrt(cc));
		if((Math.floor(Math.sqrt(cc)) == Math.sqrt(cc)) && 
				(Math.floor(Math.cbrt(cc)) == Math.cbrt(cc)))  {
			System.out.println("JEEEEE " +  String.valueOf((int)cc));
		}
	}

}
