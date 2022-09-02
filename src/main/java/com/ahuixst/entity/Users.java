package com.ahuixst.entity;

import io.mybatis.provider.Entity;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ahui
 * @Description: TODO
 * @DateTime: 2022/8/31 - 15:26
 **/
@Data
@Entity.Table(value = "users", remark = "用户")
public class Users implements Serializable {

    @Entity.Column(id = true)
    private Integer id;
    @Entity.Column
    private String name;
    @Entity.Column
    private Integer age;

}
