package org.daisy.dotify.api.formatter;

import java.util.Stack;

/**
 * Provides methods needed to add a TOC to a formatter. Note
 * that adding contents outside of entries has no specified
 * meaning and may be ignored by a formatter. 
 * 
 * @author Joel Håkansson
 */
public interface TableOfContents extends FormatterCore {

	/**
	 * Starts a new entry with the supplied properties.
	 * 
	 * @param refId the element that this toc entry is connected to
	 */
	public void startEntry(String refId);
	
	/**
	 * Ends the current entry.
	 */
	public void endEntry();
	
    /**
	 * Starts a new entry-on-resumed with the supplied properties.
	 * 
	 * @param range the range of this entry on resumed
	 */
	public void startEntryOnResumed(String range);
	
	/**
	 * Ends the current entry-on-resumed.
	 */
	public void endEntryOnResumed();
	
    /**
     * Get the stack of entry-on-resumed elements.
     * 
     * @return the entry-on-resumed stack.
     */
    public Stack<? extends FormatterCore> getEntryOnResumedStack();
    
}
