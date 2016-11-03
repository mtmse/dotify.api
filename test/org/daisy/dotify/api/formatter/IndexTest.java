package org.daisy.dotify.api.formatter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IndexTest {
	
	@Test
	public void test0BIndex() {
		Index i = Index.new_0B(5);
		assertEquals(5, i.getValue_0B());
		assertEquals(6, i.getValue_1B());
	}
	
	@Test
	public void test1BIndex() {
		Index j = Index.new_1B(6);
		assertEquals(5, j.getValue_0B());
		assertEquals(6, j.getValue_1B());
	}
	
	@Test
	public void testIterable1BInclusive() {
		List<Integer> ret = new ArrayList<>();
		for (Index i : Index.START.toIncluding(Index.new_1B(3))) {
			ret.add(i.getValue_1B());
		}
		assertArrayEquals(new Integer[]{1, 2, 3}, ret.toArray());
	}
	
	@Test
	public void testIterable0BInclusive() {
		List<Integer> ret = new ArrayList<>();
		for (Index i : Index.START.toIncluding(Index.new_0B(2))) {
			ret.add(i.getValue_0B());
		}
		assertArrayEquals(new Integer[]{0, 1, 2}, ret.toArray());
	}
	
	@Test
	public void testIterable1BExclusive() {
		List<Integer> ret = new ArrayList<>();
		for (Index i : Index.START.toWithout(Index.new_1B(3))) {
			ret.add(i.getValue_1B());
		}
		assertArrayEquals(new Integer[]{1, 2}, ret.toArray());
	}
	
	@Test
	public void testIterable0BExclusive() {
		List<Integer> ret = new ArrayList<>();
		for (Index i : Index.START.toWithout(Index.new_0B(2))) {
			ret.add(i.getValue_0B());
		}
		assertArrayEquals(new Integer[]{0, 1}, ret.toArray());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testReverse0BIterator() {
		 Index.new_0B(1).toWithout(Index.new_0B(0));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testReverse1BIterator() {
		 Index.new_1B(2).toWithout(Index.new_1B(1));
	}

	@Test
	public void testEmptyIterator() {
		assertFalse(Index.START.toWithout(Index.START).iterator().hasNext());
	}

}