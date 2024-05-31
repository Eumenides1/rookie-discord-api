package com.rookie.stack.discord.users.service.register;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rookie.stack.discord.users.domain.vo.req.register.EmailRegistrationDetails;
import com.rookie.stack.discord.users.domain.vo.req.register.GithubRegistrationDetails;
import com.rookie.stack.discord.users.domain.vo.req.register.PhoneRegistrationDetails;
import lombok.Data;

/**
 * @author eumenides
 * @description 通用用户注册信息抽象
 * @date 2024/5/31
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmailRegistrationDetails.class, name = "email"),
        @JsonSubTypes.Type(value = PhoneRegistrationDetails.class, name = "phone"),
        @JsonSubTypes.Type(value = GithubRegistrationDetails.class, name = "github"),
})
public abstract class RegistrationDetails {
    private String type;
}
