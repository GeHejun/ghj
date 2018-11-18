package com.ghj.service;

import com.ghj.core.dto.UserDTO;
import com.ghj.core.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends AbstractShiroService<UserVO, UserDTO>{
}
