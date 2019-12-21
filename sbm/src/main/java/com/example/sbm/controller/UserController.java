package com.example.sbm.controller;

import com.example.sbm.domain.User;
import com.example.sbm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @PostMapping
    @ResponseBody
    public boolean insertUser(User user) {
        return userService.addUser(user);
    }

    @DeleteMapping
    @ResponseBody
    public int deleteFromName(String name) {
        return userService.deleteFromName(name);
    }
}