package com.ghjwh.web.controller.authority;
import com.ghjwh.model.authority.GhjAuthorityRole;
import com.ghjwh.service.authority.GhjAuthorityRoleService;
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
 * Created by ghj on 2018/11/12.
 */
@Controller
@RequestMapping("/ghjAuthorityRole/")
public class GhjAuthorityRoleController {

    @Autowired
    GhjAuthorityRoleService ghjAuthorityRoleService;

    @RequestMapping("add")
    @ResponseBody
    public String add(GhjAuthorityRole ghjAuthorityRole) {
        ghjAuthorityRoleService.save(ghjAuthorityRole);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    ghjAuthorityRoleService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(GhjAuthorityRole ghjAuthorityRole) {
	    ghjAuthorityRoleService.update(ghjAuthorityRole);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        GhjAuthorityRole ghjAuthorityRole = ghjAuthorityRoleService.findById(id);
        return ghjAuthorityRole.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GhjAuthorityRole> list = ghjAuthorityRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
