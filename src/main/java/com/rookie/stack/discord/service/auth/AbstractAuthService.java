package com.rookie.stack.discord.service.auth;

import com.rookie.stack.discord.domain.auth.dto.credentials.Credentials;
import com.rookie.stack.discord.domain.auth.vo.resp.AuthResponse;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
public abstract class AbstractAuthService<T extends Credentials> implements AuthService {
    private final Class<T> credentialsClass;

    protected AbstractAuthService(Class<T> credentialsClass) {
        this.credentialsClass = credentialsClass;
    }

    @Override
    public AuthResponse login(Credentials credentials) {
        if (credentialsClass.isInstance(credentials)) {
            T specificCredentials = credentialsClass.cast(credentials);
            return doLogin(specificCredentials);
        } else {
            throw new IllegalArgumentException("Invalid credentials type for " + this.getClass().getSimpleName());
        }
    }

    @Override
    public void logout(String token) {
        // 通用登出逻辑，如果每个实现类有不同的登出逻辑，可以让子类重写
    }

    protected abstract AuthResponse doLogin(T credentials);
}

