package io.aamzerin.kata.bankaccount.constant;

/**
 * The Enum EntryType.
 */
public enum EntryType {

	/** The credit. */
	CREDIT(1),
	/** The debit. */
	DEBIT(-1);

	/** The entry type. */
	private Integer entryType;

	/**
	 * Instantiates a new entry type.
	 *
	 * @param type
	 *            the type
	 */
	EntryType(Integer type) {
		this.entryType = type;
	}

	/**
	 * Gets the entry type.
	 *
	 * @return the entry type
	 */
	public Integer getEntryType() {
		return entryType;
	}
}