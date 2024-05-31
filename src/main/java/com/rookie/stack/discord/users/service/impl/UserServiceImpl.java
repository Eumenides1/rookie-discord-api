package com.rookie.stack.discord.users.service.impl;

import com.rookie.stack.discord.common.enums.RegisterType;
import com.rookie.stack.discord.users.dao.UsersDao;
import com.rookie.stack.discord.users.domain.entity.Users;
import com.rookie.stack.discord.users.domain.vo.resp.RegistrationResponse;
import com.rookie.stack.discord.users.service.IUsersService;
import com.rookie.stack.discord.users.service.register.RegistrationDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@Service
public class UserServiceImpl implements IUsersService {

    @Resource
    private UsersDao usersDao;

    @Override
    public Users getUserInfoByEmail(String email) {
        return usersDao.getUserByUniqueKey(RegisterType.Email.getType(), email);
    }

    @Override
    public Users getUserInfoByPhone(String phone) {
        return usersDao.getUserByUniqueKey(RegisterType.Phone.getType(), phone);
    }


}
