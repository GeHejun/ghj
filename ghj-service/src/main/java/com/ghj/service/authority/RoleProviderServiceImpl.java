package com.ghj.service.authority;

import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.entity.authority.Role;
import com.ghj.dao.authority.RoleMapper;
import com.ghj.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class RoleProviderServiceImpl extends AbstractService<Role> implements RoleService {

    @Autowired
    private RoleMapper ghjAuthorityRoleMapper;

}
