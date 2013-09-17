package com.google.code.fileconversion.converters.impl;

import java.util.List;


import com.google.code.fileconversion.converters.Converter;
import com.google.code.fileconversion.files.DelimitedFileRow;
import com.google.code.fileconversion.service.FileConversionException;
import com.google.code.fileconversion.settings.ConversionSettings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TsvToJsonConverter implements Converter {

	@Override
	public String convert(final List<DelimitedFileRow> columns, final ConversionSettings settings) throws FileConversionException {
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(columns);
	}

}
