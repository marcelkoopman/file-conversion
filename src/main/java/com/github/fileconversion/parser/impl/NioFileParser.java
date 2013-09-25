package com.github.fileconversion.parser.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.github.fileconversion.files.ConversionFile;
import com.github.fileconversion.parser.FileParser;
import com.github.fileconversion.parser.FileParsingException;


public class NioFileParser implements FileParser {

	@Override
	public final List<String> getLines(final ConversionFile convertableFile) throws FileParsingException {
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
