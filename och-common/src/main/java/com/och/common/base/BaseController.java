package com.och.common.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @author danmo
 * @date 2024-07-10 18:41:33
 */
@Slf4j
public class BaseController<T> {


    public ResResult<T> success(T data) {
        return ResResult.success(data);
    }

    public ResResult<T> success(String msg, T data) {
        return ResResult.success(msg, data);
    }

    public ResResult<T> success() {
        return ResResult.success();
    }

    public ResResult<T> error(String msg) {
        return ResResult.error(msg);
    }

    public ResResult<T> error(String msg, Object data) {
        return ResResult.error(msg, data);
    }

    public ResResult<T> error(int code, String msg) {
        return ResResult.error(code, msg);
    }

    public ResResult<T> error() {
        return ResResult.error();
    }

}
