package com.rookie.stack.discord.domain.auth.dto.credentials;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PhoneCredentials extends Credentials {
    private String phoneNumber;
    private String verificationCode;
}
