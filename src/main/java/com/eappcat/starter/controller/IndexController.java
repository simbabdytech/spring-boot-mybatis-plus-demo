package com.eappcat.starter.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.eappcat.starter.entity.User;
import com.eappcat.starter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/public")
    public List<User> index() {
        List<User> user=userMapper.findAllByPage(new Pagination(2,10));
        return user;
    }
}
