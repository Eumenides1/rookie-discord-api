package com.rookie.stack.discord.auth.domain.vo.req.register;

import com.rookie.stack.discord.auth.RegistrationDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author eumenides
 * @description 邮箱注册实体
 * @date 2024/5/31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("邮箱注册请求参数")
public class EmailRegistrationDetails extends RegistrationDetails {

    @ApiModelProperty("注册邮箱")
    @NotEmpty(message = "Email is required for email registration.")
    @Email(message = "Invalid email format.")
    private String email;


    @ApiModelProperty("密码")
    @NotEmpty(message = "Password is required for email registration.")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;
    public EmailRegistrationDetails() {
        this.setType("email");
    }
}

