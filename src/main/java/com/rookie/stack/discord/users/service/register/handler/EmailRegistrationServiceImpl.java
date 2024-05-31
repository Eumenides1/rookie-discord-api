package com.rookie.stack.discord.users.service.register.handler;

import cn.hutool.core.lang.Snowflake;
import com.rookie.stack.discord.common.enums.RegisterType;
import com.rookie.stack.discord.common.enums.UserStateEnum;
import com.rookie.stack.discord.common.utils.AssertUtil;
import com.rookie.stack.discord.users.dao.UsersDao;
import com.rookie.stack.discord.users.domain.entity.Users;
import com.rookie.stack.discord.users.domain.vo.req.register.EmailRegistrationDetails;
import com.rookie.stack.discord.users.domain.vo.resp.RegistrationResponse;
import com.rookie.stack.discord.users.service.register.AbstractRegistrationService;
import com.rookie.stack.discord.users.service.register.RegistrationDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@Service("emailRegistrationServiceImpl")
public class EmailRegistrationServiceImpl extends AbstractRegistrationService<EmailRegistrationDetails> {

    @Resource
    private UsersDao usersDao;

    @Resource
    private Snowflake snowflake;

    @Override
    protected Users doRegister(EmailRegistrationDetails registrationDetails) {
        // 校验用户邮箱的唯一性
        Users existUser = usersDao.getUserByUniqueKey(RegisterType.Email.getType(), registrationDetails.getEmail());
        AssertUtil.isEmpty(existUser,"当前账号已存在，请检查邮箱 || 手机号码");
        return Users.builder().
                userId(snowflake.nextIdStr()).
                email(registrationDetails.getEmail()).
                passwordHash(registrationDetails.getPassword()).
                state(UserStateEnum.ACTIVE.getCode())
                .build();
    }


    @Override
    public void validate(EmailRegistrationDetails registrationDetails) {
        if (registrationDetails.getEmail() == null || registrationDetails.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required for email registration.");
        }
        if (registrationDetails.getPassword() == null || registrationDetails.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password is required for email registration.");
        }
    }
}
