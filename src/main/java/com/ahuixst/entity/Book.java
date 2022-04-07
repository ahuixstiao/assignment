package com.ahuixst.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: ahui
 * @Description: TODO
 * @DateTime: 2022/3/28 - 12:55
 **/
@Data
public class Book implements Serializable {
    private Integer bookId;
    private String bookName;
    private String author;
    private BigDecimal price;
    private String remarks;

}
