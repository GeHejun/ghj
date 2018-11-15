package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.common.service.AbstractProviderService;
import com.ghj.controller.authority.UserRole;
import com.ghj.dao.authority.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserRoleProviderServiceImpl extends AbstractProviderService<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

}
