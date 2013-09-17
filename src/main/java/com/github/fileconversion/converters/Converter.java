package com.google.code.fileconversion.converters;

import java.util.List;

import com.google.code.fileconversion.files.DelimitedFileRow;
import com.google.code.fileconversion.service.FileConversionException;
import com.google.code.fileconversion.settings.ConversionSettings;


public interface Converter {
	/**
	 * Converts the input to a single String, in one go. The whole file is
	 * processed.
	 * 
	 * @param input
	 * @param settings
	 * @return
	 * @throws FileConversionException
	 */
	String convert(List<DelimitedFileRow> columns, ConversionSettings settings) throws FileConversionException;
}
