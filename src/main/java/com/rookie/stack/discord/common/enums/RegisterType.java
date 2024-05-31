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
public enum RegisterType {

    Email(0, "email"),
    Phone(1, "phone"),
    Github(2, "github"),
    WeXin(3, "weixin");

    private Integer code;

    private String type;

    private static Map<String, RegisterType> cache;

    static {
        cache = Arrays.stream(RegisterType.values()).collect(Collectors.toMap(RegisterType::getType, Function.identity()));
    }

    public static RegisterType of(String type) {
        return cache.get(type);
    }


}
