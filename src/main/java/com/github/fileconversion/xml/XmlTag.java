package com.github.fileconversion.xml;


public class XmlTag {

	private final String name;
	private final String value;

	public XmlTag(final String name, final String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public final String toString() {
		return new XmlTagWriter().getAsXml(name, value);
	}
}
