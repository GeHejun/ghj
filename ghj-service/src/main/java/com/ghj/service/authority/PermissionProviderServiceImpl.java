package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.entity.authority.Permission;
import com.ghj.dao.authority.PermissionMapper;
import com.ghj.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class PermissionProviderServiceImpl extends AbstractService<Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

}
