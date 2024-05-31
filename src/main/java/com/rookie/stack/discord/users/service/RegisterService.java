package com.rookie.stack.discord.users.service;

import com.rookie.stack.discord.users.domain.vo.resp.RegistrationResponse;
import com.rookie.stack.discord.users.service.register.RegistrationDetails;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
public interface RegisterService<T extends RegistrationDetails> {
    RegistrationResponse register(T registrationDetails);

    void validate(T registrationDetails);
}
