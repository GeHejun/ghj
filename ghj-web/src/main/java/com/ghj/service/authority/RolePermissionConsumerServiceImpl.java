package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.common.dto.RolePermissionDTO;
import com.ghj.common.service.AbstractConsumerService;
import com.ghj.common.vo.RolePermissionVO;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class RolePermissionConsumerServiceImpl extends AbstractConsumerService<RolePermissionVO,RolePermissionDTO> implements RolePermissionService {

    @Reference
    RolePermissionService rolePermissionService;

}
