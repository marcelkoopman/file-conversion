package com.google.code.fileconversion.service.impl;

import java.util.List;

import com.google.code.fileconversion.converters.impl.TsvConverter;
import com.google.code.fileconversion.converters.impl.TsvToJsonConverter;
import com.google.code.fileconversion.converters.impl.TsvToXmlConverter;
import com.google.code.fileconversion.files.ConversionFile;
import com.google.code.fileconversion.files.DelimitedFile;
import com.google.code.fileconversion.files.DelimitedFileRow;
import com.google.code.fileconversion.service.FileConversionException;
import com.google.code.fileconversion.service.FileConversionService;
import com.google.code.fileconversion.settings.ConversionSettings;
import com.google.code.fileconversion.writer.FileWriterException;
import com.google.code.fileconversion.writer.impl.NioFileWriter;


public class FileConversionServiceImpl implements FileConversionService {

	@Override
	public void convertToXml(final DelimitedFile file, final ConversionFile xmlFile, final ConversionSettings settings)
			throws FileConversionException {

		final List<DelimitedFileRow> columns = parseFileAsRows(file, settings);
		final String convertedData = new TsvToXmlConverter().convert(columns, settings);
		try {
			new NioFileWriter().writeData(convertedData, xmlFile);
		} catch (final FileWriterException e) {
			throw new FileConversionException(e);
		}
	}

	@Override
	public void convertToJson(final DelimitedFile file, final ConversionFile jsonFile, final ConversionSettings settings)
			throws FileConversionException {
		final List<DelimitedFileRow> columns = parseFileAsRows(file, settings);
		final String convertedData = new TsvToJsonConverter().convert(columns, settings);
		try {
			new NioFileWriter().writeData(convertedData, jsonFile);
		} catch (final FileWriterException e) {
			throw new FileConversionException(e);
		}
	}

	@Override
	public List<DelimitedFileRow> parseFileAsRows(final DelimitedFile input, final ConversionSettings setting) throws FileConversionException {
		return new TsvConverter().convertToColumns(input, setting);
	}

}