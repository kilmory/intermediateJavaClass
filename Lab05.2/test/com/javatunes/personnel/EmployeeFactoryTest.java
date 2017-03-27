package com.javatunes.personnel;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class EmployeeFactoryTest {
  private Map<String,String> seMap;
  private Map<String,String> heMap;
  
  /**
   * client input request is a Map<String,String>, here's a sample
   * key        value
   * ---        -----
   * type       HE or SE
   * name       Jackie
   * hireDate   1990-08-24
   * 
   * salary     50000.00
   *        OR
   * rate       50.0
   * hours      40.0
   * 
   * NOTES:
   * 1. yes, we have redundant setup code, and even some redundant test code (to keep it simple)
   * 2. this is representative of how UIs send user input data to an application:
   *    - Java Swing UI components all return their input data as strings
   *    - in webapps, HTTP requests from browsers (e.g., a form submission) carry all values as strings
   */
  @Before
  public void init() {
    seMap = new HashMap<>();
    seMap.put("type",     "SE");
    seMap.put("name",     "Jackie");
    seMap.put("hireDate", "1990-08-24");
    seMap.put("salary",   "50000.0");
    
    heMap = new HashMap<>();
    heMap.put("type",     "HE");
    heMap.put("name",     "Jackie");
    heMap.put("hireDate", "1990-08-24");
    heMap.put("rate",     "50.0");
    heMap.put("hours",    "40.0");
  }
  
  @Test
  public void testCreateEmployeeSalaried() {
    // get Employee from factory - exact type driven by "type" entry in map
    Employee emp = EmployeeFactory.createEmployee(seMap);
    verifyBaseProperties(emp);  // name, hireDate
    
    // check type of object returned from factory
    assertEquals(SalariedEmployee.class, emp.getClass());
    assertTrue(emp instanceof SalariedEmployee);  // alternative - what's the difference?
    
    // downcast and check subclass-specific properties
    SalariedEmployee salariedEmp = (SalariedEmployee) emp;
    assertEquals(50000.0, salariedEmp.getSalary(), .001);
  }

  @Test
  public void testCreateEmployeeHourly() {
    // get Employee from factory - exact type driven by "type" entry in map
    Employee emp = EmployeeFactory.createEmployee(heMap);
    verifyBaseProperties(emp);
    
    // check type of object returned from factory
    assertEquals(HourlyEmployee.class, emp.getClass());
    assertTrue(emp instanceof HourlyEmployee);  // alternative - what's the difference?
    
    // safely downcast and check subclass-specific properties
    HourlyEmployee hourlyEmp = (HourlyEmployee) emp;
    assertEquals(50.0, hourlyEmp.getRate(), .001);
    assertEquals(40.0, hourlyEmp.getHours(), .001);
  }

  private void verifyBaseProperties(Employee emp) {
    assertEquals("Jackie", emp.getName());
    assertEquals("1990-08-24", emp.getHireDate().toString());
  }
}