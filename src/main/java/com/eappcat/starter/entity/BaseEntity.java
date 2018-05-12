package com.eappcat.starter.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 用来做基本字段
 */
@Data
@Accessors(chain = true)
public class BaseEntity {
    protected String _id;
    private String createdby;
    private Date createddate;
    private String updatedby;
    private Date updateddate;
    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }
}
