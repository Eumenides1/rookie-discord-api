package com.rookie.stack.discord.common.exception;

import com.rookie.stack.discord.common.domain.vo.resp.ApiResult;
import com.rookie.stack.discord.common.error.CommonErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ApiResult illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("illegalArgument exception！The reason is: ", e);
        return ApiResult.fail(CommonErrorEnum.SYSTEM_ERROR.getErrorCode(), e.getMessage());
    }

}
