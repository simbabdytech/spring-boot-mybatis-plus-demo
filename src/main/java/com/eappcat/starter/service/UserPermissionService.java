package com.eappcat.starter.service;

import com.eappcat.starter.entity.UserPermission;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xuan Yue Bo
 * @since 2018-05-12
 */
public interface UserPermissionService extends IService<UserPermission> {
    List<String> findUserPermissions(String userId);
}
