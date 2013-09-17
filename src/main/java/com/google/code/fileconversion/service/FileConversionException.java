package com.google.code.fileconversion.service;

public class FileConversionException extends Exception {
	private static final long serialVersionUID = 1L;

	public FileConversionException(Exception e) {
		super(e);
	}
}
