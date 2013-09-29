package com.github.fileconversion.settings;

public interface ConversionSettings {
    boolean getSkipEmptyTags();
    boolean zipOutput();
    int getOutputSplitSize();
}
