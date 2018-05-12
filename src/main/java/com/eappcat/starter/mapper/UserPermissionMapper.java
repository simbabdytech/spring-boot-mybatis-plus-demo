package com.eappcat.starter.mapper;

import com.eappcat.starter.entity.UserPermission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Xuan Yue Bo
 * @since 2018-05-12
 */
public interface UserPermissionMapper extends BaseMapper<UserPermission> {
    List<String> findUserPermissions(String userId);
}
