package com.agenthun.javaweb;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by agenthun on 15/12/21.
 */
public class SaxFilterTest {
    private static class BookXMLFilterImpl extends XMLFilterImpl {
        private boolean isElement = false;

        public BookXMLFilterImpl(XMLReader parent) {
            super(parent);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            if (localName.equals("media clearfix")) {
                super.startElement(uri, localName, qName, atts);
                isElement = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                super.characters(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (localName.equals("media clearfix")) {
                super.endElement(uri, localName, qName);
                isElement = false;
            }
        }
    }

    public static void main(String[] args) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser");
        XMLFilter filter = new BookXMLFilterImpl(reader); //初始化过滤器
        DefaultHandler defaultHandler = new SAXHandler();
        filter.setContentHandler(defaultHandler); //为过滤后的事件流设置defaultHandler
        filter.setErrorHandler(defaultHandler);//为过滤后的事件流设置ErrorHandler
        filter.parse("src/com/agenthun/javaweb/testFilter.xml"); //开始解析XML文件
    }

    private static class SAXHandler extends DefaultHandler {

        //处理文档解析开始事件
        @Override
        public void startDocument() throws SAXException {
            // TODO Auto-generated method stub
            System.out.println("<?xml version=\"1.0\" encodin='gb2312'?>");
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            // TODO Auto-generated method stub
            System.out.print("<" + qName);
            int len = attributes.getLength();
            for (int i = 0; i < len; i++) {
                System.out.print(" ");
                System.out.print(attributes.getQName(i));
                System.out.print("=\"");
                System.out.print(attributes.getValue(i));
                System.out.print("\"");
            }
            System.out.print(">");

        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // TODO Auto-generated method stub
            System.out.print("</" + qName + ">");
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            // TODO Auto-generated method stub
            System.out.print(new String(ch, start, length));
        }

        //处理 接戏中产生处理指令事件
        @Override
        public void processingInstruction(String target, String data)
                throws SAXException {
            // TODO Auto-generated method stub
            System.out.print("<?" + target + " " + data + " ?>");
        }
    }
}
