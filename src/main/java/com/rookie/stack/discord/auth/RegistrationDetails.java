package com.rookie.stack.discord.auth;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rookie.stack.discord.auth.domain.vo.req.register.EmailRegistrationDetails;
import com.rookie.stack.discord.auth.domain.vo.req.register.GithubRegistrationDetails;
import com.rookie.stack.discord.auth.domain.vo.req.register.PhoneRegistrationDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "用户注册核心参数")
public abstract class RegistrationDetails {

    @ApiModelProperty("注册类型：email、github")
    private String type;

    @ApiModelProperty("非前端提交参数！")
    private String localString;
}
