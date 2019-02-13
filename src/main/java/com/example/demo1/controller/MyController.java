package com.example.demo1.controller;

import com.example.demo1.model.User;
import com.example.demo1.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myController")
public class MyController extends BaseController{

    @Autowired
    private UserService userService;

    @Value("${com.example.demo1.model.userName}")
    private String userName;

    @Value("${com.example.demo1.model.passWord}")
    private String passWord;

    @ApiOperation(value="测试配置属性", notes="测试一下")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getUser1() throws Exception {
//        throw new Exception("异常来了");
        logger.info(userName + ":" + passWord);
        return userName + ":" + passWord;
    }


    @ApiOperation(value="获取用户详细信息", notes="获取用户详细信息啊")
    @ApiImplicitParam(name = "id", value = "用户ID", required = false, dataType = "String")
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public List<User> getUser(String id) {
        List<User>  resList = this.userService.getUser(id);
        return resList;
    }
}
