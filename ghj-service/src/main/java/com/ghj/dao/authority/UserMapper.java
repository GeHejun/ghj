package com.ghj.dao.authority;


import com.ghj.entity.authority.User;
import com.ghj.dao.MyMapper;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper extends MyMapper<User> {
}