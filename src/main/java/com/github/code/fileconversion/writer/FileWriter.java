package com.google.code.fileconversion.writer;

import com.google.code.fileconversion.files.ConversionFile;

public interface FileWriter {
	void writeData(String data, ConversionFile file) throws FileWriterException;
}
