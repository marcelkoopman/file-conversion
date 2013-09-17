package com.github.fileconversion.converters.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrTokenizer;

import com.google.code.fileconversion.files.ConversionFile;
import com.google.code.fileconversion.files.DelimitedFileRow;
import com.google.code.fileconversion.parser.FileParsingException;
import com.google.code.fileconversion.parser.impl.NioFileParser;
import com.google.code.fileconversion.service.FileConversionException;
import com.google.code.fileconversion.settings.ConversionSettings;

public class TsvConverter {

	public List<DelimitedFileRow> convertToColumns(final ConversionFile input, final ConversionSettings settings) throws FileConversionException {
		final List<String> lines = getLines(input);
		final String[] headers = getHeader(lines);
		final List<String> records = lines.subList(1, lines.size());
		final List<DelimitedFileRow> result = new ArrayList<DelimitedFileRow>();
		final boolean skipEmptyTags = settings.getSkipEmptyTags();
		int lineNumber = 1;
		for (final String line : records) {
			final Map<String, String> map = new LinkedHashMap<String, String>();
			final StrTokenizer tsvInstance = StrTokenizer.getTSVInstance(line);
			final String[] columnValues = tsvInstance.getTokenArray();
			for (int i = 0; i < headers.length; ++i) {
				if (skipEmptyTags && StringUtils.isEmpty(columnValues[i])) {
					// Skip
				} else {
					map.put(headers[i], columnValues[i]);
				}
			}
			final DelimitedFileRow row = new DelimitedFileRow();
			row.setRecord(map);
			row.setLineNumber(lineNumber++);
			result.add(row);
		}
		return result;
	}

	private List<String> getLines(final ConversionFile file) throws FileConversionException {
		List<String> lines;
		try {
			lines = new NioFileParser().getLines(file);
		} catch (final FileParsingException e) {
			throw new FileConversionException(e);
		}
		return lines;
	}

	private String[] getHeader(final List<String> lines) {
		final StrTokenizer tsvInstance = StrTokenizer.getTSVInstance(lines.get(0));
		final String[] header = tsvInstance.getTokenArray();
		return header;
	}
}
