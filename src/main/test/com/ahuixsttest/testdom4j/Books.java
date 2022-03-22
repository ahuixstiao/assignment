package com.ahuixsttest.testdom4j;

import java.math.BigDecimal;

/**
 * @Author: ahui
 * @Description: TODO
 * @DateTime: 2022/3/4 - 19:34
 **/
public class Books {

    private String SN;
    private String name;
    private BigDecimal price;
    private String author;

    public Books(String SN, String name, BigDecimal price, String author) {
        this.SN = SN;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Books{" +
                "SN='" + SN + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
