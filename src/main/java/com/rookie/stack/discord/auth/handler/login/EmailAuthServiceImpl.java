package com.rookie.stack.discord.auth.handler.login;

import com.rookie.stack.discord.domain.auth.dto.credentials.EmailCredentials;
import com.rookie.stack.discord.domain.auth.vo.resp.AuthResponse;
import com.rookie.stack.discord.auth.AbstractAuthService;
import org.springframework.stereotype.Service;

/**
 * @author eumenides
 * @description 邮箱登录实现
 * @date 2024/5/31
 */
@Service
public class EmailAuthServiceImpl extends AbstractAuthService<EmailCredentials> {
    public EmailAuthServiceImpl() {
        super(EmailCredentials.class);
    }

    @Override
    protected AuthResponse doLogin(EmailCredentials credentials) {
        // 在这里实现登录逻辑


        return null;
    }
}
