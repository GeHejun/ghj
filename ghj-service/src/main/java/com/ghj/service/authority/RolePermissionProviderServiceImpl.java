package com.ghj.service.authority;

import com.ghj.authority.RolePermission;
import com.ghj.dao.authority.RolePermissionMapper;
import com.ghj.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class RolePermissionProviderServiceImpl extends AbstractService<RolePermission> implements RolePermissionService {

    @Autowired
    private RolePermissionMapper ghjAuthorityRolePermissionMapper;

}
