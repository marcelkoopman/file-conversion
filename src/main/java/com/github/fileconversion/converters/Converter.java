package com.github.fileconversion.converters;

import java.util.List;

import com.github.fileconversion.files.DelimitedFileRow;
import com.github.fileconversion.service.FileConversionException;
import com.github.fileconversion.settings.ConversionSettings;


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
