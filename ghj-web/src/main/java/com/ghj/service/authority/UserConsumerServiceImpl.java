package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.common.dto.UserDTO;
import com.ghj.service.AbstractConsumerService;
import com.ghj.common.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserConsumerServiceImpl extends AbstractConsumerService<UserVO,UserDTO> {

    @Reference
    UserService userService;


}
