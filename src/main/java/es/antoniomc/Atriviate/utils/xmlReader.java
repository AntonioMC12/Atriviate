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

  /*
   * private static List<String> getFemaleEmployeesName(Document doc, XPath xpath)
   * { List<String> list = new ArrayList<>(); try { //create XPathExpression
   * object XPathExpression expr =
   * xpath.compile("/Employees/Employee[gender='Female']/name/text()"); //evaluate
   * expression result on XML document NodeList nodes = (NodeList)
   * expr.evaluate(doc, XPathConstants.NODESET); for (int i = 0; i <
   * nodes.getLength(); i++) list.add(nodes.item(i).getNodeValue()); } catch
   * (XPathExpressionException e) { e.printStackTrace(); } return list; }
   * 
   * 
   * private static List<String> getEmployeeNameWithAge(Document doc, XPath xpath,
   * int age) { List<String> list = new ArrayList<>(); try { XPathExpression expr
   * = xpath.compile("/Employees/Employee[age>" + age + "]/name/text()"); NodeList
   * nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET); for (int i =
   * 0; i < nodes.getLength(); i++) list.add(nodes.item(i).getNodeValue()); }
   * catch (XPathExpressionException e) { e.printStackTrace(); } return list; }
   */

  public static String getConectionInfo(String data) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder;
    Document doc = null;
    String url = null;
    try {
      builder = factory.newDocumentBuilder();
      doc = builder.parse(App.class.getResourceAsStream("server.xml"));

      // Create XPathFactory object
      XPathFactory xpathFactory = XPathFactory.newInstance();

      // Create XPath object
      XPath xpath = xpathFactory.newXPath();
      XPathExpression expr = xpath.compile("/conexion/" + data + "/text()");
      url = (String) expr.evaluate(doc, XPathConstants.STRING);

    } catch (XPathExpressionException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return url;
  }

}