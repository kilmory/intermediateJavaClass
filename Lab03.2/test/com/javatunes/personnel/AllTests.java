/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AllTests {
  
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(SalariedEmployeeTest.class, HourlyEmployeeTest.class);
    
    System.out.println("==== TEST RESULTS ====");
    System.out.println("Tests passed: " + result.wasSuccessful());
    System.out.println("Failures: " + result.getFailureCount());
    for (Failure f : result.getFailures()) {
      System.out.println(" - " + f);
    }
  }
}