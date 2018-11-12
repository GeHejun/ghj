package service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/12.
 */
@Service
public class GhjAuthorityRoleConsumerServiceImpl extends AbstractService<GhjAuthorityRole> implements GhjAuthorityRoleService {

    @Autowired
    private GhjAuthorityRoleMapper ghjAuthorityRoleMapper;

}
