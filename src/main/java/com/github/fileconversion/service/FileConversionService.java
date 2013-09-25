package com.github.fileconversion.service;

import java.util.List;

import com.github.fileconversion.files.ConversionFile;
import com.github.fileconversion.files.DelimitedFile;
import com.github.fileconversion.files.DelimitedFileRow;
import com.github.fileconversion.settings.ConversionSettings;


public interface FileConversionService {
	void convertToXml(DelimitedFile input, ConversionFile output, ConversionSettings setting) throws FileConversionException;

	void convertToJson(DelimitedFile input, ConversionFile output, ConversionSettings setting) throws FileConversionException;

	List<DelimitedFileRow> parseFileAsRows(DelimitedFile input, ConversionSettings setting) throws FileConversionException;
}
