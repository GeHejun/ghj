package com.ghjwh.web.controller.authority;
import com.ghjwh.model.authority.GhjAuthorityUserRole;
import com.ghjwh.service.authority.GhjAuthorityUserRoleService;
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
@RequestMapping("/ghjAuthorityUserRole/")
public class GhjAuthorityUserRoleController {

    @Autowired
    GhjAuthorityUserRoleService ghjAuthorityUserRoleService;

    @RequestMapping("add")
    @ResponseBody
    public String add(GhjAuthorityUserRole ghjAuthorityUserRole) {
        ghjAuthorityUserRoleService.save(ghjAuthorityUserRole);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    ghjAuthorityUserRoleService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(GhjAuthorityUserRole ghjAuthorityUserRole) {
	    ghjAuthorityUserRoleService.update(ghjAuthorityUserRole);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        GhjAuthorityUserRole ghjAuthorityUserRole = ghjAuthorityUserRoleService.findById(id);
        return ghjAuthorityUserRole.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GhjAuthorityUserRole> list = ghjAuthorityUserRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
