package com.eappcat.starter.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eappcat.starter.entity.BaseEntity;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xuan Yue Bo
 * @since 2018-05-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tbl_user_role")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String userid;
    private String roleid;

}
