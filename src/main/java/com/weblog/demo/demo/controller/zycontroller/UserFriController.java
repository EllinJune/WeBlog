package com.weblog.demo.demo.controller.zycontroller;

import com.weblog.demo.demo.service.zyservice.UserFriService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserFriController {
    @Resource
    private UserFriService userFriService;
}
