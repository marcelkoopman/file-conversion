package com.google.code.fileconversion.writer.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

import com.google.code.fileconversion.files.ConversionFile;
import com.google.code.fileconversion.writer.FileWriter;
import com.google.code.fileconversion.writer.FileWriterException;


public class NioFileWriter implements FileWriter {

	@Override
	public void writeData(final String data, final ConversionFile file) throws FileWriterException {
		try (BufferedWriter writer = Files.newBufferedWriter(file.getPath(), file.getCharset())) {
			writer.write(data);
		} catch (final IOException x) {
			throw new FileWriterException(x);
		}
	}
}
