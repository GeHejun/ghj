package com.ghj.service.authority;


import com.ghj.authority.Permission;
import com.ghj.dao.authority.PermissionMapper;
import com.ghj.common.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class PermissionProviderServiceImpl extends AbstractService<Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

}
