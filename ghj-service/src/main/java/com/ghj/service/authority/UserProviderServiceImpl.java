package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;
import com.ghj.common.dto.UserDTO;
import com.ghj.service.AbstractProviderService;
import com.ghj.entity.authority.User;
import com.ghj.dao.authority.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserProviderServiceImpl extends AbstractProviderService<UserDTO,User> implements UserService {

    @Autowired
    private UserMapper ghjAuthorityUserMapper;

}
