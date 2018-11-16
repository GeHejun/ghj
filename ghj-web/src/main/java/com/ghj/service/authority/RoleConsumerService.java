package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.core.dto.RoleDTO;
import com.ghj.core.vo.RoleVO;
import com.ghj.service.AbstractConsumerService;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class RoleConsumerService extends AbstractConsumerService<RoleVO,RoleDTO> {
    @Reference
    RoleService roleService;




}
