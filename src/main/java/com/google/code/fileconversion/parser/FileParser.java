package com.google.code.fileconversion.parser;

import java.util.List;

import com.google.code.fileconversion.files.ConversionFile;


public interface FileParser {
	List<String> getLines(final ConversionFile convertableFile) throws FileParsingException;
}
