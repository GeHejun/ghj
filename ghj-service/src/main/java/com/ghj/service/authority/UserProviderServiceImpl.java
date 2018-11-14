package com.ghj.service.authority;


import com.ghj.controller.authority.User;
import com.ghj.dao.authority.UserMapper;
import com.ghj.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserProviderServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserMapper ghjAuthorityUserMapper;

}
