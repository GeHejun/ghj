package com.ghjwh.web.controller.authority;
import com.ghjwh.model.authority.GhjAuthorityRolePermission;
import com.ghjwh.service.authority.GhjAuthorityRolePermissionService;
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
public class GhjAuthorityRolePermissionController {

    @Autowired
    GhjAuthorityRolePermissionService ghjAuthorityRolePermissionService;

    @RequestMapping("add")
    @ResponseBody
    public String add(GhjAuthorityRolePermission ghjAuthorityRolePermission) {
        ghjAuthorityRolePermissionService.save(ghjAuthorityRolePermission);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    ghjAuthorityRolePermissionService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(GhjAuthorityRolePermission ghjAuthorityRolePermission) {
	    ghjAuthorityRolePermissionService.update(ghjAuthorityRolePermission);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        GhjAuthorityRolePermission ghjAuthorityRolePermission = ghjAuthorityRolePermissionService.findById(id);
        return ghjAuthorityRolePermission.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GhjAuthorityRolePermission> list = ghjAuthorityRolePermissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
