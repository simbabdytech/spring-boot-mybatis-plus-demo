package com.eappcat.starter.service.impl;

import com.eappcat.starter.entity.UserRole;
import com.eappcat.starter.mapper.UserRoleMapper;
import com.eappcat.starter.service.UserRoleService;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public List<String> findUserRoles(String userId) {
        return this.baseMapper.findUserRoles(userId);
    }
}
