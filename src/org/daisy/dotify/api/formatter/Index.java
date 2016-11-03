package org.daisy.dotify.api.formatter;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Index {
	public static final Index START = Index.new_0B(0);

	private final int value;
	
	private Index(int value) {
		this.value = value;
	}

	public static Index new_0B(int value) {
		return new Index(value);
	}
	
	public static Index new_1B(int value) {
		return new Index(value-1);
	}
	
	public int getValue_0B() {
		return value;
	}
	
	public int getValue_1B() {
		return value+1;
	}
	
	public Iterable<Index> toWithout(Index end) {
		return new IndexIterable(end.getValue_0B());
	}
	
	public Iterable<Index> toIncluding(Index end) {
		return new IndexIterable(end.getValue_0B()+1);
	}
	
	private class IndexIterable implements Iterable<Index> {
		private final int end;

		private IndexIterable(int end) {
			if (value>end) {
				throw new IllegalArgumentException("To must be > than from.");
			}
			this.end = end;
		}

		@Override
		public Iterator<Index> iterator() {
			return new IndexIterator(end);
		}
	}
	
	private class IndexIterator implements Iterator<Index> {
		private final int end;
		private int currentIndex;

		private IndexIterator(int end) {
			this.end = end;
			this.currentIndex = value;
		}

		@Override
		public boolean hasNext() {
			return currentIndex < end;
		}

		@Override
		public Index next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			try {
				return Index.new_0B(currentIndex);
			} finally {
				currentIndex++;
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
}
