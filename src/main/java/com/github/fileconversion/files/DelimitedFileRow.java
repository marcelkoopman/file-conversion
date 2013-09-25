package com.github.fileconversion.files;

import java.util.Map;

public class DelimitedFileRow {

	private int lineNumber;
	private Map<String, String> record;

	public final int getLineNumber() {
		return lineNumber;
	}

	public final void setLineNumber(final int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public final Map<String, String> getRecord() {
		return record;
	}

	public final void setRecord(final Map<String, String> record) {
		this.record = record;
	}

}
