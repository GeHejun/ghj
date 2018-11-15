package com.ghj.service.authority;

import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.common.service.AbstractProviderService;
import com.ghj.controller.authority.Role;
import com.ghj.dao.authority.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class RoleProviderServiceImpl extends AbstractProviderService<Role> implements RoleService {

    @Autowired
    private RoleMapper ghjAuthorityRoleMapper;

}
