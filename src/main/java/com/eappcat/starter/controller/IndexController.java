package com.eappcat.starter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.eappcat.starter.base.Result;
import com.eappcat.starter.entity.User;
import com.eappcat.starter.mapper.UserMapper;
import com.eappcat.starter.model.LoginVO;
import com.google.common.base.Preconditions;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/public")
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AuthenticationManager authenticationManager;
    @GetMapping
    public List<User> index() {
        List<User> user=userMapper.findAllByPage(new Pagination(2,10));
        return user;
    }

    @PostMapping("/login")
    @ApiOperation(value="登录api", notes="根据用户名密码登陆")
    public Result<Map> login(
            @RequestBody LoginVO user, HttpServletRequest request) throws AuthenticationServiceException {
        Preconditions.checkArgument(user.getUsername()!=null);
        Preconditions.checkArgument(user.getPassword()!=null);
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        HashMap map=new HashMap();
        Result<Map> result=new Result();
        List<String> access=new ArrayList();
        if(authentication.getAuthorities()!=null){
            for(GrantedAuthority grantedAuthority : authentication.getAuthorities()){
                access.add(grantedAuthority.getAuthority());
            }
        }

        map.put("permissions",access);
        return result.setData(map);
    }
    @GetMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        request.getSession().invalidate();
        Result<String> result=new Result();
        return result.setData("logout");
    }
}
