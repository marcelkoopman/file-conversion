package com.github.fileconversion.files;

import java.nio.charset.Charset;
import java.nio.file.Path;

public interface ConversionFile {
	Path getPath();

	Charset getCharset();
}
