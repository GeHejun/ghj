package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;

import com.ghj.core.dto.UserDTO;
import com.ghj.service.AbstractProviderService;
import com.ghj.entity.authority.User;
import com.ghj.dao.authority.UserMapper;
import com.ghj.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserProviderServiceImpl extends AbstractProviderService<UserDTO,User> implements UserService,MyService<UserDTO,User> {

    @Autowired
    private UserMapper userMapper;




}
