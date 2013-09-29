package com.github.fileconversion.writer;

import com.github.fileconversion.files.ConversionFile;

public interface FileWriter {
	void writeData(String data, ConversionFile file) throws FileWriterException;
}
