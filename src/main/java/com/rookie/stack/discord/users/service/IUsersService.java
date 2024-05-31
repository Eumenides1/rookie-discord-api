package com.rookie.stack.discord.users.service;

import com.rookie.stack.discord.users.domain.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rookie.stack.discord.users.domain.vo.resp.RegistrationResponse;
import com.rookie.stack.discord.users.service.register.RegistrationDetails;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author jaguarliu
 * @since 2024-05-31
 */
public interface IUsersService {

    Users getUserInfoByEmail(String email);


    Users getUserInfoByPhone(String phone);





}
