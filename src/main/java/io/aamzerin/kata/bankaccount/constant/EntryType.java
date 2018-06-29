package io.aamzerin.kata.bankaccount.constant;

public enum EntryType {
    CREDIT(1), DEBIT(2);
	
	private Integer entryType;

	EntryType(Integer type) {
        this.entryType = type;
    }

    public Integer getEntryType() {
    	return entryType;
    }
}