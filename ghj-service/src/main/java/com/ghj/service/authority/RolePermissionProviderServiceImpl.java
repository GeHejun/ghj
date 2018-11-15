package com.ghj.service.authority;

import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.common.dto.RolePermissionDTO;
import com.ghj.common.service.AbstractProviderService;
import com.ghj.entity.authority.RolePermission;
import com.ghj.dao.authority.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class RolePermissionProviderServiceImpl extends AbstractProviderService<RolePermissionDTO,RolePermission> implements RolePermissionService {

    @Autowired
    private RolePermissionMapper ghjAuthorityRolePermissionMapper;

}
