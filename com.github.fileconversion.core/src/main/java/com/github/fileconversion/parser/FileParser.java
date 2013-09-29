package com.github.fileconversion.parser;

import java.util.List;

import com.github.fileconversion.files.ConversionFile;


public interface FileParser {
	List<String> getLines(final ConversionFile convertableFile) throws FileParsingException;
}
