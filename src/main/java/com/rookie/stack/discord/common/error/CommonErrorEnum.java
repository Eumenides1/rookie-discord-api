package com.rookie.stack.discord.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author eumenides
 * @description 通用系统异常
 * @date 2024/5/31
 */
@AllArgsConstructor
@Getter
public enum CommonErrorEnum implements ErrorEnum {

    BUSINESS_ERROR(0, "{0}"),
    SYSTEM_ERROR(-1, "系统出小差了，请稍后再试哦~~"),
    PARAM_INVALID(-2, "参数校验失败{0}"),
    FREQUENCY_LIMIT(-3, "请求太频繁了，请稍后再试哦~~"),
    LOCK_LIMIT(-4, "请求太频繁了，请稍后再试哦~~"),
    ;
    private final Integer code;
    private final String msg;

    @Override
    public Integer getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMsg() {
        return this.msg;
    }
}
