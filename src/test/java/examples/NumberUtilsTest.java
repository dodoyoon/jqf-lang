package org.apache.commons.lang3.math;

import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.runner.RunWith;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

@RunWith(JQF.class)
public class NumberUtilsTest{

	private boolean checkCreateNumber(final String val) {	//return true if no NumberFormatException and obj is not null
		try {
			final Object obj = NumberUtils.createNumber(val);
			return obj != null;
		} catch (final NumberFormatException e) {
			return false;
		}
	}

	@Fuzz
	public void testIsNumberLANG1385(String val) {
		boolean isValid = NumberUtils.isCreatable(val);
		boolean canCreate = checkCreateNumber(val);
		assertTrue("Expected isValid-" + isValid+ " and canCreate-" + canCreate + " to be equal for val-" + val, isValid == canCreate);
	}

}

