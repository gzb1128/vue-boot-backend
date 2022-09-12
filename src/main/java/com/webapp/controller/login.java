package com.webapp.controller;

import com.webapp.pojo.User;
import com.webapp.service.UserService;
import com.webapp.util.Response;
import com.webapp.util.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class login {
    HttpSession session;
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @PostMapping("/login")
    @ResponseBody
    public Response login(@RequestBody User user) {
        log.info("login into backend, user={}", user);
        if (userService.getUserLoginInfo(user.getName(), user.getPwd())) {
            return Response.success("Success");
        } else {
            session.setAttribute("user", user);
            return Response.fail(ReturnCode.USERNAME_OR_PASSWORD_ERROR);
        }
    }
}
