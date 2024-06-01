package com.rookie.stack.discord.auth;

import com.rookie.stack.discord.auth.domain.vo.resp.RegistrationResponse;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
public interface RegisterService<T extends RegistrationDetails> {
    RegistrationResponse register(T registrationDetails);

}
