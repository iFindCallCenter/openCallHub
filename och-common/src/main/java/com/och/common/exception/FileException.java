package com.och.common.exception;

/**
 * @author danmo
 * @date 2023年07月09日 23:46
 */
public class FileException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected String message;

    private Integer code = -1;

    public FileException(String message)
    {
        this.message = message;
    }

    public FileException(Integer code, String message)
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
