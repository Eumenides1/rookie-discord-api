package com.rookie.stack.discord.users.service.register;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rookie.stack.discord.common.exception.BusinessException;
import com.rookie.stack.discord.users.dao.UsersDao;
import com.rookie.stack.discord.users.domain.entity.Users;
import com.rookie.stack.discord.users.domain.vo.resp.RegistrationResponse;
import com.rookie.stack.discord.users.mapper.UsersMapper;
import com.rookie.stack.discord.users.service.RegisterService;

import javax.annotation.Resource;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
public abstract class AbstractRegistrationService<T extends  RegistrationDetails>
        extends ServiceImpl<UsersMapper, Users>
        implements RegisterService<T> {

    @Resource
    private UsersDao dao;

    @Override
    public RegistrationResponse register(T registrationDetails) {
        validate(registrationDetails);
        Users user = doRegister(registrationDetails);
        int i = dao.insertUser(user);
        if (i != 1) {
            throw new BusinessException("用户创建失败！");
        }
        return new RegistrationResponse();
    }

    protected abstract Users doRegister(T registrationDetails);

    @Override
    public abstract void validate(T registrationDetails);
}
