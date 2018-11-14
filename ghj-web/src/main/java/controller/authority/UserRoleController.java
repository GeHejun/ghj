package controller.authority;

import com.ghj.authority.UserRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import service.authority.UserRoleConsumerServiceImpl;

/**
 *
 * Created by ghj on 2018/11/14.
 */
@Controller
@RequestMapping("/ghjAuthorityUserRole/")
public class UserRoleController {

    @Autowired
    UserRoleConsumerServiceImpl userRoleConsumerService;

    @RequestMapping("add")
    @ResponseBody
    public String add(UserRole ghjAuthorityUserRole) {
        userRoleConsumerService.save(ghjAuthorityUserRole);
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
    public String update(UserRole ghjAuthorityUserRole) {
	    userRoleConsumerService.update(ghjAuthorityUserRole);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        UserRole ghjAuthorityUserRole = userRoleConsumerService.findById(id);
        return ghjAuthorityUserRole.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserRole> list = userRoleConsumerService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
