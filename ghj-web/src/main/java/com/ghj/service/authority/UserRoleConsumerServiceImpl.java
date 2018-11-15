package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.common.dto.UserRoleDTO;
import com.ghj.service.AbstractConsumerService;
import com.ghj.common.vo.UserRoleVO;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserRoleConsumerServiceImpl extends AbstractConsumerService<UserRoleVO,UserRoleDTO> implements UserRoleService<UserRoleVO,UserRoleDTO> {

    @Reference
    UserRoleService userRoleService;


}
