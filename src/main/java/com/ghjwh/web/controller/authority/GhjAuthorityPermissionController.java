package com.ghjwh.web.controller.authority;
import com.ghjwh.model.authority.GhjAuthorityPermission;
import com.ghjwh.service.authority.GhjAuthorityPermissionService;
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
@RequestMapping("/ghjAuthorityPermission/")
public class GhjAuthorityPermissionController {

    @Autowired
    GhjAuthorityPermissionService ghjAuthorityPermissionService;

    @RequestMapping("add")
    @ResponseBody
    public String add(GhjAuthorityPermission ghjAuthorityPermission) {
        ghjAuthorityPermissionService.save(ghjAuthorityPermission);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    ghjAuthorityPermissionService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(GhjAuthorityPermission ghjAuthorityPermission) {
	    ghjAuthorityPermissionService.update(ghjAuthorityPermission);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        GhjAuthorityPermission ghjAuthorityPermission = ghjAuthorityPermissionService.findById(id);
        return ghjAuthorityPermission.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GhjAuthorityPermission> list = ghjAuthorityPermissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
