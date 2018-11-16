package com.ghj.controller.authority;


import com.ghj.core.vo.UserVO;
import com.ghj.service.authority.UserConsumerService;
import com.ghj.service.authority.UserService;
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
@RequestMapping("/authorityUser/")
public class UserController {

    @Autowired
    UserConsumerService userConsumerService;

    @RequestMapping("add")
    @ResponseBody
    public String add(UserVO userVO) throws InstantiationException, IllegalAccessException {
        userConsumerService.save(userVO);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    userConsumerService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(UserVO userVO) throws InstantiationException, IllegalAccessException {
	    userConsumerService.update(userVO);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) throws InstantiationException, IllegalAccessException {
        UserVO userVO = (UserVO) userConsumerService.findById(id);
        return userVO.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size)
            throws InstantiationException, IllegalAccessException {
        List<UserVO> list = userConsumerService.findAll();
        return list.toString();
    }
}
