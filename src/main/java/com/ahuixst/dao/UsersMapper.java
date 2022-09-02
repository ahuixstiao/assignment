package com.ahuixst.dao;

import com.ahuixst.entity.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ahui
 * @Description: TODO
 * @DateTime: 2022/8/31 - 15:29
 **/
@Mapper //将接口交由Mybatis为接口生成代理实现类 这也是为什么明明没有去实现接口也能直接调用方法执行
public interface UsersMapper extends io.mybatis.mapper.Mapper<Users, Long> {

}
