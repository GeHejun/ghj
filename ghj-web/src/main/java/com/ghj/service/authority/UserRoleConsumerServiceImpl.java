package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.core.dto.UserRoleDTO;
import com.ghj.core.vo.UserRoleVO;
import com.ghj.service.AbstractConsumerService;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserRoleConsumerServiceImpl extends AbstractConsumerService<UserRoleVO,UserRoleDTO> {

    @Reference
    UserRoleService userRoleService;


}
