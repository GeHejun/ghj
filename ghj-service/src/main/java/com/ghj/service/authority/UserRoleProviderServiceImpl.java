package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.common.dto.UserRoleDTO;
import com.ghj.service.AbstractProviderService;
import com.ghj.entity.authority.UserRole;
import com.ghj.dao.authority.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserRoleProviderServiceImpl extends AbstractProviderService<UserRoleDTO,UserRole>{

    @Autowired
    private UserRoleMapper userRoleMapper;

}
