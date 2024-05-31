package com.rookie.stack.discord.users.dao;

import com.rookie.stack.discord.users.domain.entity.Users;
import com.rookie.stack.discord.users.mapper.UsersMapper;
import com.rookie.stack.discord.users.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author jaguarliu
 * @since 2024-05-31
 */
@Service
public class UsersDao extends ServiceImpl<UsersMapper, Users>{

}
