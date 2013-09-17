package com.google.code.fileconversion.parser.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.code.fileconversion.files.ConversionFile;
import com.google.code.fileconversion.parser.FileParser;
import com.google.code.fileconversion.parser.FileParsingException;


public class NioFileParser implements FileParser {

	@Override
	public List<String> getLines(final ConversionFile convertableFile) throws FileParsingException {
		final List<String> lines = new ArrayList<String>();
		final Charset charset = convertableFile.getCharset();
		final Path path = convertableFile.getPath();
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (final IOException x) {
			throw new FileParsingException(x);
		}

		return lines;
	}
}
