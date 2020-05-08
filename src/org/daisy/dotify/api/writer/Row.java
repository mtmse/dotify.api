package org.daisy.dotify.api.writer;

/**
 * Defines a row of braille.
 * 
 * @author Joel Håkansson
 */
public interface Row {

	/**
	 * Gets the characters 
	 * @return returns the characters
	 */
	public String getChars();

	/**
	 * Gets the row spacing, in rows
	 * @return the row spacing, or null if not set
	 */
	public Float getRowSpacing();

    /**
     * This is an object that will be sent through the Dotify framework from the
     * external reference tag in the OBFL specification and then used in the writer
     * to add information to the rows of the PEF.
     * This extra reference is not a part of the official PEF specification and used
     * when the output is not meant for print.
     *
     * @return External reference object
     */
	public Object getExternalReference();
}
