package org.daisy.dotify.api.formatter;

import java.util.Optional;
import static org.junit.Assert.assertEquals;
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
	public void testStandardRange() {
		TocEntryOnResumedRange range = new TocEntryOnResumedRange("[ch_1,ch_2)");
		assertEquals("ch_1", range.getStartRefId());
		Optional<String> endRefId = range.getEndRefId();
		assertTrue(endRefId.isPresent());
		assertEquals("ch_2", endRefId.get());
	}
	
	@Test
	public void testUnboundedRange() {
		TocEntryOnResumedRange range = new TocEntryOnResumedRange("[ch_1,)");
		assertEquals("ch_1", range.getStartRefId());
		Optional<String> endRefId = range.getEndRefId();
		assertTrue(endRefId.isEmpty());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testUnsupportedRange() {
		TocEntryOnResumedRange range = new TocEntryOnResumedRange("[ch_1,ch_2]");
	}
	
	@Test(expected = RuntimeException.class)
	public void testInvalidRange() {
		TocEntryOnResumedRange range = new TocEntryOnResumedRange("[,)");
	}

}

