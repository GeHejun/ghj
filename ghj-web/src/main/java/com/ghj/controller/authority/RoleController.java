package com.ghj.controller.authority;


import com.ghj.core.vo.RoleVO;
import com.ghj.service.authority.RoleConsumerServiceImpl;
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
@RequestMapping("/authorityRole/")
public class RoleController {

    @Autowired
    RoleConsumerServiceImpl roleConsumerService;

    @RequestMapping("add")
    @ResponseBody
    public String add(RoleVO roleVO) throws InstantiationException, IllegalAccessException {
        roleConsumerService.save(roleVO);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
        roleConsumerService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(RoleVO roleVO) throws InstantiationException, IllegalAccessException {
        roleConsumerService.update(roleVO);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) throws InstantiationException, IllegalAccessException {
        RoleVO roleVO = (RoleVO) roleConsumerService.findById(id);
        return roleVO.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size)
            throws InstantiationException, IllegalAccessException {
        List<RoleVO> list = roleConsumerService.findAll();
        return list.toString();
    }
}
