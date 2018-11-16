package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.core.dto.PermissionDTO;
import com.ghj.dao.authority.PermissionMapper;
import com.ghj.entity.authority.Permission;
import com.ghj.service.AbstractProviderService;
import com.ghj.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class PermissionProviderServiceImpl extends AbstractProviderService<PermissionDTO,Permission> implements PermissionService,MyService<PermissionDTO,Permission> {

    @Autowired
    private PermissionMapper permissionMapper;



}
