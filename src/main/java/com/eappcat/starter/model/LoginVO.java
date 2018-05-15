package com.eappcat.starter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class LoginVO {
    @ApiModelProperty(required = true, example = "admin")
    private String username;
    @ApiModelProperty(required = true, example = "1")
    private String password;
}
