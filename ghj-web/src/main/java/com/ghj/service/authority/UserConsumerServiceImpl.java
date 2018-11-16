package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ghj.core.dto.UserDTO;
import com.ghj.core.vo.UserVO;
import com.ghj.service.AbstractConsumerService;
import java.util.List;
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
