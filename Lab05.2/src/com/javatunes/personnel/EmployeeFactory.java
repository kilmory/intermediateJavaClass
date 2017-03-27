/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {
  
  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }
  
  public static Employee createEmployee(Map<String,String> inputMap) {
    // return value
    Employee emp = null;
    
    // read map and create correct Employee type accordingly (via "type" entry)
    String type = inputMap.get("type");
    
    if ("SE".equals(type)) {
      SalariedEmployee salariedEmp = new SalariedEmployee();
      salariedEmp.setName(inputMap.get("name"));
      salariedEmp.setHireDate(Date.valueOf(inputMap.get("hireDate")));
      salariedEmp.setSalary(Double.parseDouble(inputMap.get("salary")));
      emp = salariedEmp;
    }
    if ("HE".equals(type)) {
      HourlyEmployee hourlyEmp = new HourlyEmployee();
      hourlyEmp.setName(inputMap.get("name"));
      hourlyEmp.setHireDate(Date.valueOf(inputMap.get("hireDate")));
      hourlyEmp.setRate(Double.parseDouble(inputMap.get("rate")));
      hourlyEmp.setHours(Double.parseDouble(inputMap.get("hours")));
      emp = hourlyEmp;
    }
    return emp;
  }
}