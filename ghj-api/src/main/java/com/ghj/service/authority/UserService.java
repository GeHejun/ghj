package com.ghj.service.authority;


import com.ghj.core.dto.RoleDTO;
import com.ghj.core.dto.UserDTO;
import java.util.List;
import tk.mybatis.mapper.entity.Condition;

/**
 *
 * Created by ghj on 2018/11/14.
 */
public interface UserService{

    List<RoleDTO> listRolesByUserName(String userName);

    UserDTO findUserDTOByUserName(String userName);
}
