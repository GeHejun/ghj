package com.ghj.controller.authority;

import com.ghj.core.vo.UserRoleVO;
import com.ghj.service.authority.UserRoleConsumerService;
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
@RequestMapping("/ghjAuthorityUserRole/")
public class UserRoleController {

    @Autowired
    UserRoleConsumerService userRoleConsumerService;

    @RequestMapping("add")
    @ResponseBody
    public String add(UserRoleVO userRoleVO) throws InstantiationException, IllegalAccessException {
        userRoleConsumerService.save(userRoleVO);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    userRoleConsumerService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(UserRoleVO userRoleVO) throws InstantiationException, IllegalAccessException {
	    userRoleConsumerService.update(userRoleVO);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) throws InstantiationException, IllegalAccessException {
        UserRoleVO userRoleVO = (UserRoleVO) userRoleConsumerService.findById(id);
        return userRoleVO.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size)
            throws InstantiationException, IllegalAccessException {
        List<UserRoleVO> list = userRoleConsumerService.findAll();
        return list.toString();
    }
}
