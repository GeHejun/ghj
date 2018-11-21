package com.ghj.service.authority;


import com.alibaba.dubbo.config.annotation.Service;

import com.ghj.core.dto.RoleDTO;
import com.ghj.core.dto.UserDTO;
import com.ghj.dao.authority.RoleMapper;
import com.ghj.dao.authority.UserRoleMapper;
import com.ghj.entity.authority.Role;
import com.ghj.entity.authority.UserRole;
import com.ghj.service.AbstractProviderService;
import com.ghj.entity.authority.User;
import com.ghj.dao.authority.UserMapper;
import com.ghj.service.MyService;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;

/**
 * Created by ghj on 2018/11/14.
 */
@Service
public class UserProviderServiceImpl extends AbstractProviderService<UserDTO, User> implements UserService, MyService<UserDTO, User> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<RoleDTO> listRolesByUserName(String userName) {
        User user = new User();
        user.setUsername(userName);
        List<User> userList = userMapper.select(user);
        List<RoleDTO> roleDTOS = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(userList)) {
            UserRole userRole = new UserRole();
            userRole.setUserid(userList.get(0).getId());
            List<UserRole> userRoleList = userRoleMapper.select(userRole);
            if (!CollectionUtils.isEmpty(userRoleList)) {
                userRoleList.forEach(userRoleForRoleId -> {
                    Role role = new Role();
                    role.setId(userRoleForRoleId.getId());
                    List<Role> select = roleMapper.select(role);
                    if (!CollectionUtils.isEmpty(select)) {
                        select.forEach(roleResult -> {
                            RoleDTO roleDTO = new RoleDTO();
                            BeanUtils.copyProperties(role, roleDTO);
                            roleDTOS.add(roleDTO);
                        });
                    }
                });
            }
        }
        return roleDTOS;
    }

    @Override
    public UserDTO findUserDTOByUserName(String userName) {
        User user = new User();
        user.setUsername(userName);
        List<User> userList = userMapper.select(user);
        UserDTO userDTO = new UserDTO();
        if (!CollectionUtils.isEmpty(userList)) {
            BeanUtils.copyProperties(userList.get(0), userDTO);
        }
        return userDTO;
    }
}
