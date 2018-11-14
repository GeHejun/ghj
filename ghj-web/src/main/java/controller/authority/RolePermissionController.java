package controller.authority;

import com.ghj.authority.RolePermission;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import service.authority.RolePermissionConsumerServiceImpl;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Controller
@RequestMapping("/ghjAuthorityRolePermission/")
public class RolePermissionController {

    @Autowired
    RolePermissionConsumerServiceImpl rolePermissionConsumerService;

    @RequestMapping("add")
    @ResponseBody
    public String add(RolePermission ghjAuthorityRolePermission) {
        rolePermissionConsumerService.save(ghjAuthorityRolePermission);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
        rolePermissionConsumerService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(RolePermission ghjAuthorityRolePermission) {
        rolePermissionConsumerService.update(ghjAuthorityRolePermission);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        RolePermission ghjAuthorityRolePermission = rolePermissionConsumerService.findById(id);
        return ghjAuthorityRolePermission.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<RolePermission> list = rolePermissionConsumerService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
