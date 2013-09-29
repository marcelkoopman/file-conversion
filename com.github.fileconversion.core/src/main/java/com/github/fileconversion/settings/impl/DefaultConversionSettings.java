package com.github.fileconversion.settings.impl;

import com.github.fileconversion.settings.ConversionSettings;

public class DefaultConversionSettings implements ConversionSettings {
	private final boolean skipEmptyTags = true;

	@Override
	public final boolean getSkipEmptyTags() {
		return skipEmptyTags;
	}

	@Override
	public final boolean zipOutput() {
		return false;
	}

	@Override
	public final int getOutputSplitSize() {
		// FIXME this is a magic number
		return 7000;
	}
}
