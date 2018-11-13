package com.ghjwh.web.controller.authority;
import com.ghjwh.model.authority.GhjAuthorityUser;
import com.ghjwh.service.authority.GhjAuthorityUserService;
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
@RequestMapping("/ghjAuthorityUser/")
public class GhjAuthorityUserController {

    @Autowired
    GhjAuthorityUserService ghjAuthorityUserService;

    @RequestMapping("add")
    @ResponseBody
    public String add(GhjAuthorityUser ghjAuthorityUser) {
        ghjAuthorityUserService.save(ghjAuthorityUser);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    ghjAuthorityUserService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(GhjAuthorityUser ghjAuthorityUser) {
	    ghjAuthorityUserService.update(ghjAuthorityUser);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        GhjAuthorityUser ghjAuthorityUser = ghjAuthorityUserService.findById(id);
        return ghjAuthorityUser.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GhjAuthorityUser> list = ghjAuthorityUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
