/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HourlyEmployeeTest {
  private HourlyEmployee emp;
  
  @BeforeClass
  public static void beginTestRun() {
    System.out.println("beginTestRun");
  }
  
  @AfterClass
  public static void endTestRun() {
    System.out.println("endTestRun");
  }
  
  @Before
  public void init() {
    System.out.println("init");
    emp = new HourlyEmployee("Leanne", Date.valueOf("1990-08-24"), 25.0, 32.0);
  }
  
  @After
  public void destroy() {
    System.out.println("destroy");
  }

  @Test
  public void testPay() {
    System.out.println("testPay");
    //assertEquals(800.0, emp.pay(), .001);
  }
  
  @Test
  public void testPayTaxes() {
    System.out.println("testPayTaxes");
    assertEquals(6.25, emp.payTaxes(), .001);
  }
}