package com.github.fileconversion.settings.impl;

import com.github.fileconversion.settings.ConversionSettings;

public class DefaultConversionSettings implements ConversionSettings {
	private final boolean skipEmptyTags = true;

	@Override
	public boolean getSkipEmptyTags() {
		return skipEmptyTags;
	}

	@Override
	public boolean zipOutput() {
		return false;
	}

	@Override
	public int getOutputSplitSize() {
		return 7000;
	}
}
