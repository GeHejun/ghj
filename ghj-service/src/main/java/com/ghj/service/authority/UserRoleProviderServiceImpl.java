package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.controller.authority.UserRole;
import com.ghj.dao.authority.UserRoleMapper;
import com.ghj.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserRoleProviderServiceImpl extends AbstractService<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

}
