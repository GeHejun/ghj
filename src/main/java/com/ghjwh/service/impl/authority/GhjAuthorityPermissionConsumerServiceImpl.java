package com.ghjwh.service.impl.authority;

import com.ghjwh.dao.mapper.authority.GhjAuthorityPermissionMapper;
import com.ghjwh.model.authority.GhjAuthorityPermission;
import com.ghjwh.service.authority.GhjAuthorityPermissionService;
import com.ghjwh.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/12.
 */
@Service
public class GhjAuthorityPermissionConsumerServiceImpl extends AbstractService<GhjAuthorityPermission> implements GhjAuthorityPermissionService {

    @Autowired
    private GhjAuthorityPermissionMapper ghjAuthorityPermissionMapper;

}
