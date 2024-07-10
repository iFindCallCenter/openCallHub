package com.och.common.base;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.och.common.constant.HttpStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Optional;

/**
 * 操作消息提醒
 *
 * @author danmo
 */
@Data
public class ResResult<T> implements Serializable {

    private static final long serialVersionUID = 7337293201809451832L;

    @JsonIgnore
    private HashMap<String, Object> map;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    private int code;

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    private String msg;

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    private T data;

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public ResResult() {
        this.map = new HashMap<>();
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public ResResult(int code, String msg) {
        this();
        this.code = code;
        this.msg = msg;
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public ResResult(int code, String msg, T data) {
        this();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResResult success() {
        return ResResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static <T> ResResult<T> success(T data) {
        return ResResult.success("操作成功", data);
    }


    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static <T> ResResult<T> success(String msg, T data) {
        return (ResResult<T>) new ResResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static ResResult error() {
        return ResResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResResult error(String msg) {
        return ResResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResResult error(String msg, Object data) {
        return new ResResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static ResResult error(int code, String msg) {
        return new ResResult(code, msg, null);
    }

    public void put(String key, Object value) {
        this.map.put(key, value);
    }

    public JSONObject build() {
        JSONObject json = new JSONObject();
        json.put("code", getCode());
        json.put("msg", getMsg());
        json.put("data", getData());
        Optional.ofNullable(getMap()).ifPresent(m -> m.forEach(json::put));
        return json;
    }
}
