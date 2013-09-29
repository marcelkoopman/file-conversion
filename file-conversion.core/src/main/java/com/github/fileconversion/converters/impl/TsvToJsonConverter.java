package com.github.fileconversion.converters.impl;

import java.util.List;

import com.github.fileconversion.converters.Converter;
import com.github.fileconversion.files.DelimitedFileRow;
import com.github.fileconversion.service.FileConversionException;
import com.github.fileconversion.settings.ConversionSettings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TsvToJsonConverter implements Converter {

	@Override
	public final String convert(final List<DelimitedFileRow> columns, final ConversionSettings settings) throws FileConversionException {
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(columns);
	}

}
