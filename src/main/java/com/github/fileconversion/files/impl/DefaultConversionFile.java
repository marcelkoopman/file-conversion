package com.github.fileconversion.files.impl;

import java.nio.charset.Charset;
import java.nio.file.Path;

import com.github.fileconversion.files.ConversionFile;


public class DefaultConversionFile implements ConversionFile {

	private final Path path;
	private final Charset charset;

	public DefaultConversionFile(final Path path, final Charset charset) {
		this.path = path;
		this.charset = charset;
	}

	@Override
	public final Path getPath() {
		return path;
	}

	@Override
	public final Charset getCharset() {
		return charset;
	}

}
