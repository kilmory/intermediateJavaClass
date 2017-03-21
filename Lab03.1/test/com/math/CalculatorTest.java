/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		assertEquals(5, calc.add(1, 4)); // expected, actual
		assertEquals(5, calc.add(4, 1));
		assertEquals(-3, calc.add(-4, 1));
	}

	@Test
	public void testDivide() {
		Calculator calc = new Calculator();
		double result = calc.divide(5, 2);
		assertEquals(2.5, result, .001);
	}

	@Test
	public void testIsEven() {
		Calculator calc = new Calculator();
		assertTrue(calc.isEven(10));
	}
}