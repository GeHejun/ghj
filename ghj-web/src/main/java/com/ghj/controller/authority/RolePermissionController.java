package com.ghj.controller.authority;

import com.ghj.common.vo.RolePermissionVO;
import com.ghj.service.authority.RolePermissionConsumerServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Controller
@RequestMapping("/ghjAuthorityRolePermission/")
public class RolePermissionController {

    @Autowired
    RolePermissionConsumerServiceImpl rolePermissionConsumerService;

    @RequestMapping("add")
    @ResponseBody
    public String add(RolePermissionVO rolePermissionVO) throws InstantiationException, IllegalAccessException {
        rolePermissionConsumerService.save(rolePermissionVO);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
        rolePermissionConsumerService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(RolePermissionVO rolePermissionVO) throws InstantiationException, IllegalAccessException {
        rolePermissionConsumerService.update(rolePermissionVO);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) throws InstantiationException, IllegalAccessException {
        RolePermissionVO rolePermissionVO = (RolePermissionVO) rolePermissionConsumerService.findById(id);
        return rolePermissionVO.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size)
            throws InstantiationException, IllegalAccessException {
        PageHelper.startPage(page, size);
        List<RolePermissionVO> list = rolePermissionConsumerService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
