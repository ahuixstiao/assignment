package com.ahuixsttest.testdom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: ahui
 * @Description: TODO
 * @DateTime: 2022/3/4 - 19:42
 **/
public class Dom4jTest {

    @Test
    public void DocumentConversionBeanTest() throws DocumentException {
        // 实例文件读取器
        SAXReader saxReader = new SAXReader();
        // 保存读取后的文件
        Document document = saxReader.read("src/main/resources/books.xml");
        // 获取文件根标签
        Element rootElement = document.getRootElement();
        // 当要获取复数的元素时 使用elements获取
        List<Element> elementList = rootElement.elements("book");
        for (Element books : elementList) {
            //获取父元素的标签参数
            String sn = books.attributeValue("sn");
            //将element元素的参数转换成Books对象属性
            String name = books.element("name").getText();
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(books.element("price").getText()));
            String author = books.element("author").getText();
        }
    }

    @Test
    public void loadAppilicationConText(){
        String str = "Hello, World!";
        System.out.println(String.format("%s", str));
    }
}
