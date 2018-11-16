package com.ghj.controller.authority;

import com.ghj.core.vo.PermissionVO;
import com.ghj.service.authority.PermissionConsumerServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Controller
@RequestMapping("/ghjAuthorityPermission/")
public class PermissionController {

    @Autowired
    PermissionConsumerServiceImpl permissionConsumerService;

    @RequestMapping("add")
    @ResponseBody
    public String add(PermissionVO permissionVO) throws InstantiationException, IllegalAccessException {
        permissionConsumerService.save(permissionVO);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
        permissionConsumerService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(PermissionVO permissionVO) throws InstantiationException, IllegalAccessException {
        permissionConsumerService.update(permissionVO);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) throws InstantiationException, IllegalAccessException {
        PermissionVO permissionVO = (PermissionVO) permissionConsumerService.findById(id);
        return permissionVO.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size)
            throws InstantiationException, IllegalAccessException {
        List<PermissionVO> list = permissionConsumerService.findAll();
        return list.toString();
    }
}
