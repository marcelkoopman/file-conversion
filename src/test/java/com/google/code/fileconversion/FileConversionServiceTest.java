package com.google.code.fileconversion;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.junit.Test;

import com.google.code.fileconversion.files.impl.DefaultConversionFile;
import com.google.code.fileconversion.files.impl.TsvFile;
import com.google.code.fileconversion.service.FileConversionException;
import com.google.code.fileconversion.service.FileConversionService;
import com.google.code.fileconversion.service.impl.FileConversionServiceImpl;
import com.google.code.fileconversion.settings.impl.DefaultConversionSettings;

public class FileConversionServiceTest {

	@Test
	public void testConvertTsv2Xml() throws FileNotFoundException, FileConversionException {
		final Path tsvFilePath = Paths.get("src/test/resources/base_product-130920132306.csv");
		final Path xmlFilePath = Paths.get("src/test/resources/base_product6.xml");
		final FileConversionService fileConversionService = new FileConversionServiceImpl();
		fileConversionService.convertToXml(new TsvFile(tsvFilePath, StandardCharsets.ISO_8859_1), new DefaultConversionFile(xmlFilePath,
				StandardCharsets.UTF_8), new DefaultConversionSettings());
	}

	// @Test
	public void testConvertTsv2Json() throws FileNotFoundException, FileConversionException {
		final Path tsvFilePath = Paths.get("src/test/resources/base_product-100920132336.csv");
		final Path jsonFilePath = Paths.get("src/test/resources/base_product5.json");
		final FileConversionService fileConversionService = new FileConversionServiceImpl();
		fileConversionService.convertToJson(new TsvFile(tsvFilePath, StandardCharsets.ISO_8859_1), new DefaultConversionFile(jsonFilePath,
				StandardCharsets.UTF_8), new DefaultConversionSettings());
	}
}
