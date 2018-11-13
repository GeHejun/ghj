package com.ghjwh.service.impl.authority;

import com.ghjwh.dao.mapper.authority.GhjAuthorityUserRoleMapper;
import com.ghjwh.model.authority.GhjAuthorityUserRole;
import com.ghjwh.service.authority.GhjAuthorityUserRoleService;
import com.ghjwh.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class GhjAuthorityUserRoleProviderServiceImpl extends AbstractService<GhjAuthorityUserRole> implements GhjAuthorityUserRoleService {

    @Autowired
    private GhjAuthorityUserRoleMapper ghjAuthorityUserRoleMapper;

}
