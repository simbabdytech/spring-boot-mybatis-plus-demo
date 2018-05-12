package com.eappcat.starter.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.eappcat.starter.entity.User;
import com.eappcat.starter.mapper.UserMapper;
import com.eappcat.starter.service.PermissionService;
import com.eappcat.starter.service.UserPermissionService;
import com.eappcat.starter.service.UserRoleService;
import com.eappcat.starter.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xuan Yue Bo
 * @since 2018-05-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService,UserDetailsService {

    @Autowired
    UserPermissionService userPermissionService;
    @Autowired
    UserRoleService userRoleService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User result=baseMapper.findByUsername(s);
        User user=new User();
        user.setName(s);
        User result=baseMapper.selectOne(user);
        if(result == null){
            throw new UsernameNotFoundException("User cannot be found");
        }
        List<String> permissions=userPermissionService.findUserPermissions(result.getId());
        List<GrantedAuthority> grantedAuthorities=new ArrayList();
        if(permissions!=null){
            for (String permission:permissions){
                GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(permission);
                grantedAuthorities.add(grantedAuthority);
            }
        }
//        List<String> roles=userRoleService.findUserRoles(result.getId());
//        if(roles!=null){
//            for (String role:roles){
//                GrantedAuthority grantedAuthority=new SimpleGrantedAuthority("ROLE_"+role);
//                grantedAuthorities.add(grantedAuthority);
//            }
//        }

        return new org.springframework.security.core.userdetails.User(s,result.getPassword(),grantedAuthorities);
    }
}
