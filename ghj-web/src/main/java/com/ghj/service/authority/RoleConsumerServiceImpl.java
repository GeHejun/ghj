package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.common.dto.RoleDTO;
import com.ghj.service.AbstractConsumerService;
import com.ghj.common.vo.RoleVO;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class RoleConsumerServiceImpl extends AbstractConsumerService<RoleVO,RoleDTO> implements RoleService<RoleVO,RoleDTO>{
    @Reference
    RoleService roleService;




}
