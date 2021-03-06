package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.core.dto.RolePermissionDTO;
import com.ghj.core.vo.RolePermissionVO;
import com.ghj.service.AbstractConsumerService;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class RolePermissionConsumerService extends AbstractConsumerService<RolePermissionVO,RolePermissionDTO> {

    @Reference
    RolePermissionService rolePermissionService;


}
