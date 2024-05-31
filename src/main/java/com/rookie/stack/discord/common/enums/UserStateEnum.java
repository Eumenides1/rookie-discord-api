package com.rookie.stack.discord.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@AllArgsConstructor
@Getter
public enum UserStateEnum {

    ACTIVE(0, "正常状态"),
    SILENCED(1, "账号被禁"),
    DELETED(2, "账号被删除");

    private Integer code;

    private String state;

    private static Map<String, UserStateEnum> cache;

    static {
        cache = Arrays.stream(UserStateEnum.values()).collect(Collectors.toMap(UserStateEnum::getState, Function.identity()));
    }

    public static UserStateEnum of(String type) {
        return cache.get(type);
    }


}
