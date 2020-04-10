package org.daisy.dotify.api.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class NumeralStyleTest {

	@Test
	public void testNumeralStyleDefault() {
		assertEquals("1", NumeralStyle.DEFAULT.format(1));
	}
	
	@Test
	public void testNumeralStyleDecimal() {
		assertEquals("5", NumeralStyle.DECIMAL.format(5));
	}

	@Test
	public void testNumeralStyleRoman() {
		assertEquals("III", NumeralStyle.ROMAN.format(3));
	}
	
	@Test
	public void testNumeralStyleLowerRoman() {
		assertEquals("iii", NumeralStyle.LOWER_ROMAN.format(3));
	}

	@Test
	public void testNumeralStyleAlpha() {
		assertEquals("C", NumeralStyle.ALPHA.format(3));
	}
	
	@Test
	public void testNumeralStyleLowerAlpha() {
		assertEquals("c", NumeralStyle.LOWER_ALPHA.format(3));
	}
	
	@Test
	public void testNumeralStyleLeadingZero_01() {
		assertEquals("09", NumeralStyle.DECIMAL_LEADING_ZERO.format(9));
	}
	
	@Test
	public void testNumeralStyleLeadingZero_02() {
		assertEquals("10", NumeralStyle.DECIMAL_LEADING_ZERO.format(10));
	}
    
    @Test
    public void testNumeralStyleStringDefault() {
		assertEquals("1", NumeralStyle.DEFAULT.format("1"));        
		assertEquals("test", NumeralStyle.DEFAULT.format("test"));        
    }

    @Test
	public void testNumeralStyleStringLowerRoman() {
		assertEquals("iii", NumeralStyle.LOWER_ROMAN.format("3"));
		assertEquals("iii", NumeralStyle.LOWER_ROMAN.format("3.0"));
		assertEquals("iii", NumeralStyle.LOWER_ROMAN.format("3.499"));
		assertEquals("iv", NumeralStyle.LOWER_ROMAN.format("3.5"));
	}

    @Test
	public void testNumeralStyleStringLowerRomanWithInvalidInput() {
        // this will produce a warning in the log but does not fail
		assertEquals("test", NumeralStyle.LOWER_ROMAN.format("test"));
	}

}
