package com.eappcat.starter.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@TableName("tbl_user")
@Data
public class User {
    @TableId("_id")
    private String id;
    private String name;
    private String password;
}
