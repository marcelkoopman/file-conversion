package com.github.fileconversion.files.impl;

import java.nio.charset.Charset;
import java.nio.file.Path;

import com.github.fileconversion.files.DelimitedFile;


public class CsvFile extends DefaultConversionFile implements DelimitedFile {

	private static final String COMMA = ",";

	public CsvFile(final Path path, final Charset charset) {
		super(path, charset);
	}

	@Override
	public final String getDelimiter() {
		return COMMA;
	}
}
