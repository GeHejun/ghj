package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.common.dto.PermissionDTO;
import com.ghj.service.AbstractConsumerService;
import com.ghj.common.vo.PermissionVO;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class PermissionConsumerServiceImpl extends AbstractConsumerService<PermissionVO,PermissionDTO> implements PermissionService<PermissionVO,PermissionDTO>{

    @Reference
    PermissionService permissionService;



}
