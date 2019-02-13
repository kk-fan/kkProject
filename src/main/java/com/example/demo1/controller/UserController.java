package com.example.demo1.controller;

import com.example.demo1.model.User;
import com.example.demo1.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: kkfan
 * @Date: 2019/1/13 10:53
 * @Description:
 */
@RestController
@RequestMapping(value = "/userManage")
@Api(value = "用户管理层", tags = "用户管理")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")  // 校验只有拥有admin权限才可访问
//    @PostMapping("/getUser")
//    public List<User> getUserList(@RequestBody UserQuery userQuery) {
//        List<User> userList = this.userService.getUserList();
//        return userList;
//    }
}
