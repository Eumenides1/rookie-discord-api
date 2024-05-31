package com.rookie.stack.discord.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@AllArgsConstructor
@Getter
public enum BusinessErrorEnum implements ErrorEnum {
    //==================================common==================================
    BUSINESS_ERROR(1001, "{0}"),
    //==================================user==================================
    //==================================chat==================================
    SYSTEM_ERROR(1001, "系统出小差了，请稍后再试哦~~"),
    ;
    private Integer code;
    private String msg;

    @Override
    public Integer getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return msg;
    }
}

