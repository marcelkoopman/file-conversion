package com.github.fileconversion.writer.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

import com.github.fileconversion.files.ConversionFile;
import com.github.fileconversion.writer.FileWriter;
import com.github.fileconversion.writer.FileWriterException;


public class NioFileWriter implements FileWriter {

	@Override
	public final void writeData(final String data, final ConversionFile file) throws FileWriterException {
		try (BufferedWriter writer = Files.newBufferedWriter(file.getPath(), file.getCharset())) {
			writer.write(data);
		} catch (final IOException x) {
			throw new FileWriterException(x);
		}
	}
}
