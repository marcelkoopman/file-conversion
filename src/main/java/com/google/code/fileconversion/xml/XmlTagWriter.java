package com.google.code.fileconversion.xml;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;

public class XmlTagWriter {

	public String getAsXml(final String tagName, final String content) {
		final StrBuilder strBuilder = new StrBuilder();
		if (StringUtils.isEmpty(content)) {
			strBuilder.append("<");
			strBuilder.append(tagName);
			strBuilder.append("/>");
		} else {
			strBuilder.append("<");
			strBuilder.append(tagName);
			strBuilder.append(">");
			strBuilder.append(StringEscapeUtils.escapeXml(content));
			strBuilder.append("</");
			strBuilder.append(tagName);
			strBuilder.append(">");
		}
		return strBuilder.toString();
	}
}
