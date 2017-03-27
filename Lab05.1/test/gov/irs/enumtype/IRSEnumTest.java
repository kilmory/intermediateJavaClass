/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package gov.irs.enumtype;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.javatunes.corp.Corporation;
import gov.irs.holder.IRS;

public class IRSEnumTest {

	/**
	 * TODO: verify that two calls to IRSEnum.getInstance() return the same
	 * instance.
	 */
	@Test
	public void testSingleton() {

	}

	@Test
  public void testClassLoading() {
      IRSEnum.touch();// and note the output
    
    // TODO: call IRSEnum.getInstance() and note the output
      IRSEnum.getInstance();
  }

	@Test
	public void testNormalClientUsage() {
		IRSEnum irs = IRSEnum.getInstance();
		irs.register(new Corporation("JavaTunes"));
		irs.collectTaxes();
	}
}