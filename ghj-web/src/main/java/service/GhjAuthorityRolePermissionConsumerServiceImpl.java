package service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/12.
 */
@Service
public class GhjAuthorityRolePermissionConsumerServiceImpl extends AbstractService<GhjAuthorityRolePermission> implements GhjAuthorityRolePermissionService {

    @Autowired
    private GhjAuthorityRolePermissionMapper ghjAuthorityRolePermissionMapper;

}
