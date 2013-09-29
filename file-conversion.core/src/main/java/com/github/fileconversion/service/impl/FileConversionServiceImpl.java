package com.github.fileconversion.service.impl;

import java.util.List;

import com.github.fileconversion.converters.impl.TsvConverter;
import com.github.fileconversion.converters.impl.TsvToJsonConverter;
import com.github.fileconversion.converters.impl.TsvToXmlConverter;
import com.github.fileconversion.files.ConversionFile;
import com.github.fileconversion.files.DelimitedFile;
import com.github.fileconversion.files.DelimitedFileRow;
import com.github.fileconversion.service.FileConversionException;
import com.github.fileconversion.service.FileConversionService;
import com.github.fileconversion.settings.ConversionSettings;
import com.github.fileconversion.writer.FileWriterException;
import com.github.fileconversion.writer.impl.NioFileWriter;


public class FileConversionServiceImpl implements FileConversionService {

	@Override
	public final void convertToXml(final DelimitedFile file, final ConversionFile xmlFile, final ConversionSettings settings)
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
	public final void convertToJson(final DelimitedFile file, final ConversionFile jsonFile, final ConversionSettings settings)
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
	public final List<DelimitedFileRow> parseFileAsRows(final DelimitedFile input, final ConversionSettings setting) throws FileConversionException {
		return new TsvConverter().convertToColumns(input, setting);
	}
}
