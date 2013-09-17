package com.google.code.fileconversion.files.impl;

import java.nio.charset.Charset;
import java.nio.file.Path;

import com.google.code.fileconversion.files.ConversionFile;


public class DefaultConversionFile implements ConversionFile {

	private final Path path;
	private final Charset charset;

	public DefaultConversionFile(final Path path, final Charset charset) {
		this.path = path;
		this.charset = charset;
	}

	@Override
	public Path getPath() {
		return path;
	}

	@Override
	public Charset getCharset() {
		return charset;
	}

}
