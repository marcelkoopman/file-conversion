package com.github.fileconversion.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlFormatter {

	public final String prettyFormat(final String xml, final int indent) throws TransformerException {
		final Source xmlInput = new StreamSource(new StringReader(xml));
		final StringWriter stringWriter = new StringWriter();
		final StreamResult xmlOutput = new StreamResult(stringWriter);
		final TransformerFactory transformerFactory = TransformerFactory.newInstance();
		final Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(indent));
		transformer.transform(xmlInput, xmlOutput);
		final String string = xmlOutput.getWriter().toString();
		return string;
	}

}
