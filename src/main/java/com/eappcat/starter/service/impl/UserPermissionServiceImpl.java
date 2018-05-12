package com.eappcat.starter.service.impl;

import com.eappcat.starter.entity.UserPermission;
import com.eappcat.starter.mapper.UserPermissionMapper;
import com.eappcat.starter.service.UserPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xuan Yue Bo
 * @since 2018-05-12
 */
@Service
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission> implements UserPermissionService {

    public List<String> findUserPermissions(String userId){
        return baseMapper.findUserPermissions(userId);
    }
}
