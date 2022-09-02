package com.ahuixst.entity;

import io.mybatis.provider.Entity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: ahui
 * @Description: Book实体类
 * @DateTime: 2022/3/28 - 12:55
 **/
@Data
@Entity.Table(value = "book", remark = "书籍")
public class Book implements Serializable {

    @Entity.Column(id = true)
    private Integer bookId;
    @Entity.Column
    private String bookName;
    @Entity.Column
    private String image;
    @Entity.Column
    private String author;
    @Entity.Column
    private BigDecimal price;
    @Entity.Column
    private String remarks;
}
