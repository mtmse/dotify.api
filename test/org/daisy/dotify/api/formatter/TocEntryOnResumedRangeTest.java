package org.daisy.dotify.api.formatter;

import java.text.ParseException;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit tests for class TocEntryOnResumedRange
 * 
 * @author Paul Rambags
 */
@SuppressWarnings("javadoc")
public class TocEntryOnResumedRangeTest {
	
	@Test
	public void testStandardRange() throws ParseException {
		TocEntryOnResumedRange range = new TocEntryOnResumedRange("[ch_1,ch_2)");
		assertEquals("ch_1", range.getStartRefId());
		Optional<String> endRefId = range.getEndRefId();
		assertTrue(endRefId.isPresent());
		assertEquals("ch_2", endRefId.get());
	}
	
	@Test
	public void testUnboundedRange() throws ParseException {
		TocEntryOnResumedRange range = new TocEntryOnResumedRange("[ch_1,)");
		assertEquals("ch_1", range.getStartRefId());
		Optional<String> endRefId = range.getEndRefId();
		assertFalse(endRefId.isPresent());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testUnsupportedRange() throws ParseException  {
		TocEntryOnResumedRange range = new TocEntryOnResumedRange("[ch_1,ch_2]");
		assertNotNull(range);
	}
	
	@Test(expected = ParseException.class)
	public void testInvalidRange() throws ParseException  {
		TocEntryOnResumedRange range = new TocEntryOnResumedRange("[,)");
		assertNotNull(range);
	}

}

