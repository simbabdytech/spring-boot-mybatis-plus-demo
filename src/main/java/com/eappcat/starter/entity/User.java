package com.eappcat.starter.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

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
 * @since 2018-05-11
 */
@Data
@Accessors(chain = true)
@TableName("tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String address;
    private String authenticate;
    private String mail;
    private String name;
    private String password;
    private String phone;
    private String sex;
    private String updatedby;
    private String mobile;
    private Date updateddate;
    private String realname;
    private Date dob;
    private String logo;
    private String createdby;
    private Date createddate;
    private String openid;


}
