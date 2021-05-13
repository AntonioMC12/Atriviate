package es.antoniomc.Atriviate.utils;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
//import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.antoniomc.Atriviate.App;

public class xmlReader {

  public static String getConectionInfo(String data) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder;
    Document doc = null;
    String url = null;
    try {
      builder = factory.newDocumentBuilder();
      doc = builder.parse(App.class.getResourceAsStream("server.xml"));

      XPathFactory xpathFactory = XPathFactory.newInstance();

      XPath xpath = xpathFactory.newXPath();
      XPathExpression expr = xpath.compile("/conexion/" + data + "/text()");
      url = (String) expr.evaluate(doc, XPathConstants.STRING);

    } catch (XPathExpressionException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }

    return url;
  }

}