package com.rookie.stack.discord.service.auth;

import com.rookie.stack.discord.domain.auth.dto.credentials.Credentials;
import com.rookie.stack.discord.domain.auth.vo.resp.AuthResponse;

/**
 * @author eumenides
 * @description 登录授权接口
 * @date 2024/5/31
 */
public interface AuthService {

    /**
     * 用户登录接口
     * @param credentials 登录凭证
     * @return 鉴权结果
     */
    AuthResponse login(Credentials credentials);

    /**
     * 退出登录
     * @param token
     */
     void logout(String token);

}
