package com.ahuixst.entity;
import lombok.Data;

/**
 * @Author: ahui
 * @Description: TODO
 * @DateTime: 2022/3/28 - 08:49
 **/
@Data
public class UserName {
    //用户名
    private String name;
    //密码
    private String password;
    //性别
    private Integer sex;
    //爱好
    private String[] hobby;
    //星座
    private String constellation;
    //个人简介
    private String personalProfile;

}
