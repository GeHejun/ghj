package com.ghjwh.service.impl.authority;

import com.ghjwh.dao.mapper.authority.GhjAuthorityRoleMapper;
import com.ghjwh.model.authority.GhjAuthorityRole;
import com.ghjwh.service.authority.GhjAuthorityRoleService;
import com.ghjwh.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class GhjAuthorityRoleProviderServiceImpl extends AbstractService<GhjAuthorityRole> implements GhjAuthorityRoleService {

    @Autowired
    private GhjAuthorityRoleMapper ghjAuthorityRoleMapper;

}
