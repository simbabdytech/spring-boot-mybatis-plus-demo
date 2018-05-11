package com.eappcat.starter.service.impl;

import com.eappcat.starter.entity.User;
import com.eappcat.starter.mapper.UserMapper;
import com.eappcat.starter.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xuan Yue Bo
 * @since 2018-05-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
