package com.testcy.xmlParse;

import com.testcy.bean.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class XmlParse {


    @Test
    public void testParseXml() throws DocumentException {
        SAXReader reader = new SAXReader();
        //JUint默认的相对路径是当前模块
        Document document = reader.read("src/xml/book.xml");
        System.out.println(document);
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
//        for (Iterator<Element> it = rootElement.elementIterator(); it.hasNext();) {
//            Element element = it.next();
//            // do something
//            System.out.println(element);
//        }
    }

    @Test
    public void pase() throws DocumentException {
        SAXReader reader = new SAXReader();
        //JUint默认的相对路径是当前模块
        Document document = reader.read("src/xml/book.xml");
        Element root = document.getRootElement();
        List<Element> books = root.elements("book");
        for (Element element : books) {
//            System.out.println(book.asXML());
            String name = element.element("name").getText();
            String author = element.elementText("author");
            String price = element.element("price").getText();
            String sn=element.attributeValue("sn");
            Book book = new Book(sn,name, author, new BigDecimal(price));
            System.out.println(book);
        }


    }
}
