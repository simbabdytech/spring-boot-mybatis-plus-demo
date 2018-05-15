package com.eappcat.starter.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private int status;
    private T data;
    private String message;

    public boolean getSuccess(){
        return status==0;
    }
}
