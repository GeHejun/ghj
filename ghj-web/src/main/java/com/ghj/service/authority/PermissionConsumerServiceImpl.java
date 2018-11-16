package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.core.dto.PermissionDTO;
import com.ghj.core.vo.PermissionVO;
import com.ghj.service.AbstractConsumerService;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class PermissionConsumerServiceImpl extends AbstractConsumerService<PermissionVO,PermissionDTO> {

    @Reference
    PermissionService permissionService;



}
