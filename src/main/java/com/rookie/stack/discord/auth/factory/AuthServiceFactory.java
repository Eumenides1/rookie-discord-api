package com.rookie.stack.discord.auth.factory;

import com.rookie.stack.discord.auth.AuthService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eumenides
 * @description 授权服务工厂
 * @date 2024/5/31
 */
@Component
public class AuthServiceFactory {

    private final Map<String, AuthService> authServiceMap;
    public AuthServiceFactory(List<AuthService> authServiceList) {
        authServiceMap = new HashMap<>();
        for (AuthService authService : authServiceList) {
            authServiceMap.put(authService.getClass().getSimpleName(), authService);
        }
    }
    public AuthService getAuthService(String loginType) {
        return authServiceMap.get(loginType + "AuthServiceImpl");
    }
}
