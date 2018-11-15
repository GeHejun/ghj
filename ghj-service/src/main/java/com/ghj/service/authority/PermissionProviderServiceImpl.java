package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.common.dto.PermissionDTO;
import com.ghj.entity.authority.Permission;
import com.ghj.dao.authority.PermissionMapper;
import com.ghj.service.AbstractProviderService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class PermissionProviderServiceImpl extends AbstractProviderService<PermissionDTO,Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

}
