package com.och.common.exception;

import lombok.Data;

/**
 * 登录异常
 * @author danmo
 * @date 2024-02-21 10:33
 **/
@Data
public class LoginException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    protected String message;

    private Integer code = -1;

    public LoginException(String message)
    {
        this.message = message;
    }

    public LoginException(Integer code, String message)
    {
        this.code=code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
