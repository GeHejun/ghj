package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.core.dto.UserRoleDTO;
import com.ghj.entity.authority.UserRole;
import com.ghj.dao.authority.UserRoleMapper;
import com.ghj.service.AbstractProviderService;
import com.ghj.service.MyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserRoleProviderServiceImpl extends AbstractProviderService<UserRoleDTO,UserRole> implements UserRoleService,MyService<UserRoleDTO,UserRole> {

    @Autowired
    private UserRoleMapper userRoleMapper;




}
