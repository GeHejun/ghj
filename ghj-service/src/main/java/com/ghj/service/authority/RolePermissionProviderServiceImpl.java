package com.ghj.service.authority;

import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.core.dto.RolePermissionDTO;
import com.ghj.dao.authority.RolePermissionMapper;
import com.ghj.entity.authority.RolePermission;
import com.ghj.service.AbstractProviderService;
import com.ghj.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class RolePermissionProviderServiceImpl extends AbstractProviderService<RolePermissionDTO,RolePermission> implements RolePermissionService,MyService<RolePermissionDTO,RolePermission> {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;



}
