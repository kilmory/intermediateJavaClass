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

import gov.irs.TaxPayer;

public class SalariedEmployee extends Employee implements TaxPayer {
	private Double salary;

	public SalariedEmployee() {
	}

	public SalariedEmployee(String name, Date hireDate) {
		setName(name);
		setHireDate(hireDate);
	}

	public SalariedEmployee(String name, Date hireDate, Double salary) {
		setName(name);
		setHireDate(hireDate);
		setSalary(salary);
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": name=" + getName() + ", hireDate=" + getHireDate() + ", salary="
				+ getSalary();
	}

	@Override
	public double payTaxes() {
		double taxes = TaxPayer.SALARIED_TAX_RATE * salary;
		System.out.println("Salaried employee: " +  getName() + " paid "+ taxes);
		return taxes;
	}
}