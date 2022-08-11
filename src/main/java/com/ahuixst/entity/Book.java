package com.ahuixst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: ahui
 * @Description: Book实体类
 * @DateTime: 2022/3/28 - 12:55
 **/
@Data
@NoArgsConstructor
public class Book implements Serializable {
    private Integer bookId;
    private String bookName;
    private String author;
    private BigDecimal price;
    private String remarks;
    
    public Book(String bookName, String author, BigDecimal price, String remarks) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.remarks = remarks;
    }
}
