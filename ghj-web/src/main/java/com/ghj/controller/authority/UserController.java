package com.ghj.controller.authority;

import com.ghj.common.vo.UserVO;
import com.ghj.service.authority.UserConsumerServiceImpl;
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
@RequestMapping("/authorityUser/")
public class UserController {

    @Autowired
    UserConsumerServiceImpl userConsumerService;

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
        PageHelper.startPage(page, size);
        List<UserVO> list = userConsumerService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
