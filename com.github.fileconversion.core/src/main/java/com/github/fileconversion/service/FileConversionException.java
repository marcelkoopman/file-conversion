package com.github.fileconversion.service;

public class FileConversionException extends Exception {
	private static final long serialVersionUID = 1L;

	public FileConversionException(final Exception e) {
		super(e);
	}
}
