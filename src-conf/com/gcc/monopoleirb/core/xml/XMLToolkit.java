package com.gcc.monopoleirb.core.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public final class XMLToolkit {

	public static final String CHARSET_STRING = Charset.forName("utf-8")
			.displayName();
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\""
			+ CHARSET_STRING + "\"?>";

	public static boolean isXMLValid(String xmlPath, String xsdPath) {

		SchemaFactory factory = SchemaFactory
				.newInstance("http://www.w3.org/2001/XMLSchema");
		try {
			// XSD schema
			File schemaLocation = new File(xsdPath);
			Schema schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			// The XML file to valid
			Source source = new StreamSource(xmlPath);
			// Launch validation
			validator.validate(source);
			return true;
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<String> getXPathValues(String xmlStream, String xPath) {
		List<String> xPathResult = new ArrayList<String>();
		try {
			DocumentBuilderFactory domFactory = DocumentBuilderFactory
					.newInstance();
			domFactory.setNamespaceAware(true);
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			Document doc = builder.parse(new ByteArrayInputStream(xmlStream
					.getBytes("utf-8")));

			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			XPathExpression expr = xpath.compile(xPath);

			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				xPathResult.add(nodes.item(i).getNodeValue());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			xPathResult = null;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			xPathResult = null;
		} catch (SAXException e) {
			e.printStackTrace();
			xPathResult = null;
		} catch (IOException e) {
			e.printStackTrace();
			xPathResult = null;
		}
		return xPathResult;
	}

	public static String getXPathValue(String xmlStream, String xPath) {
		List<String> xPathResult = getXPathValues(xmlStream, xPath);

		if (xPathResult == null || xPathResult.size() != 1) {
			return null;
		} else {
			return xPathResult.get(0);
		}
	}
}
