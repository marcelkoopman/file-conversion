package com.github.fileconversion.files;

import java.util.Map;

public class DelimitedFileRow {

	private int lineNumber;
	private Map<String, String> record;

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(final int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public Map<String, String> getRecord() {
		return record;
	}

	public void setRecord(final Map<String, String> record) {
		this.record = record;
	}

}
