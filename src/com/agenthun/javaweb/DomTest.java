package com.agenthun.javaweb;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Agent Henry on 2015/8/15.
 */
public class DomTest {
    public static void main(String[] args) {
        try {
            File f = new File("src/com/agenthun/javaweb/test.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(f);
            NodeList nodeList = doc.getElementsByTagName("p");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("name: " + doc.getElementsByTagName("name").item(i).getFirstChild().getNodeValue());
                System.out.println("age: " + doc.getElementsByTagName("age").item(i).getFirstChild().getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
