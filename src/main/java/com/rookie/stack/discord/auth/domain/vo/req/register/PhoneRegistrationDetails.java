package com.rookie.stack.discord.auth.domain.vo.req.register;

import com.rookie.stack.discord.auth.RegistrationDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author eumenides
 * @description 手机号码注册实体
 * @date 2024/5/31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PhoneRegistrationDetails extends RegistrationDetails {
    private String phone;
    private String verificationCode;
}
