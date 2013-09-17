package com.google.code.fileconversion.files.impl;

import java.nio.charset.Charset;
import java.nio.file.Path;

import com.google.code.fileconversion.files.DelimitedFile;


public class TsvFile extends DefaultConversionFile implements DelimitedFile {

	private static final String TAB = "/t";

	public TsvFile(final Path path, final Charset charset) {
		super(path, charset);
	}

	@Override
	public String getDelimiter() {
		return TAB;
	}
}
