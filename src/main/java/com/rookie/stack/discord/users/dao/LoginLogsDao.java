package com.rookie.stack.discord.users.dao;

import com.rookie.stack.discord.users.domain.entity.LoginLogs;
import com.rookie.stack.discord.users.mapper.LoginLogsMapper;
import com.rookie.stack.discord.users.service.ILoginLogsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录日志表 服务实现类
 * </p>
 *
 * @author jaguarliu
 * @since 2024-05-31
 */
@Service
public class LoginLogsDao extends ServiceImpl<LoginLogsMapper, LoginLogs> {

}
