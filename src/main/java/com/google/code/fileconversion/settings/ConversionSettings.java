package com.google.code.fileconversion.settings;

public interface ConversionSettings {
    boolean getSkipEmptyTags();
    boolean zipOutput();
    int getOutputSplitSize();
}
