package com.google.code.fileconversion.service;

import java.util.List;

import com.google.code.fileconversion.files.ConversionFile;
import com.google.code.fileconversion.files.DelimitedFile;
import com.google.code.fileconversion.files.DelimitedFileRow;
import com.google.code.fileconversion.settings.ConversionSettings;


public interface FileConversionService {
	void convertToXml(DelimitedFile input, ConversionFile output, ConversionSettings setting) throws FileConversionException;

	void convertToJson(DelimitedFile input, ConversionFile output, ConversionSettings setting) throws FileConversionException;

	List<DelimitedFileRow> parseFileAsRows(DelimitedFile input, ConversionSettings setting) throws FileConversionException;
}
