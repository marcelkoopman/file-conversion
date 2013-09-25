package com.github.fileconversion.converters.impl;

import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.apache.commons.lang3.text.StrBuilder;

import com.github.fileconversion.converters.Converter;
import com.github.fileconversion.files.DelimitedFileRow;
import com.github.fileconversion.service.FileConversionException;
import com.github.fileconversion.settings.ConversionSettings;
import com.github.fileconversion.xml.XmlFormatter;
import com.github.fileconversion.xml.XmlTag;

public class TsvToXmlConverter implements Converter {

	private static final int INDENT_AMOUNT = 4;
	private final XmlFormatter xmlFormatter = new XmlFormatter();

	@Override
	public String convert(final List<DelimitedFileRow> columns, final ConversionSettings settings) throws FileConversionException {
		final StrBuilder result = new StrBuilder();
		result.append("<file>");
		for (final DelimitedFileRow column : columns) {
			final String columnAsXml = getXml(column);
			result.append(columnAsXml);
		}
		result.append("</file>");
		try {
			return xmlFormatter.prettyFormat(result.toString(), INDENT_AMOUNT);
		} catch (final TransformerException e) {
			throw new FileConversionException(e);
		}
	}

	private String getXml(final DelimitedFileRow row) {
		final StrBuilder builder = new StrBuilder();
		builder.append("<record lineNumber='" + row.getLineNumber() + "'>");
		for (final Map.Entry<String, String> entry : row.getRecord().entrySet()) {
			final XmlTag tag = new XmlTag(entry.getKey(), entry.getValue());
			builder.append(tag.toString());
		}
		builder.append("</record>");
		return builder.toString();
	}
}
