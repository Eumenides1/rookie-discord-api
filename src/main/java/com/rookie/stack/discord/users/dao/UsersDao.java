package com.rookie.stack.discord.users.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rookie.stack.discord.common.enums.RegisterType;
import com.rookie.stack.discord.common.enums.UserStateEnum;
import com.rookie.stack.discord.common.exception.BusinessException;
import com.rookie.stack.discord.users.domain.entity.Users;
import com.rookie.stack.discord.users.mapper.UsersMapper;
import com.rookie.stack.discord.users.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Resource
    private UsersMapper usersMapper;

    /**
     * 根据用户唯一索引查询用户信息
     * @param key 用户唯一索引
     * @param value 索引值
     * @return 用户实体信息
     */
    public Users getUserByUniqueKey(String key, String value){
        RegisterType registerType = RegisterType.of(key);
        if (registerType == null) {
            throw new IllegalArgumentException("Invalid key: " + key);
        }
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        switch (registerType) {
            case Email:
                queryWrapper.eq(Users::getEmail, value);
                break;
            case Phone:
                queryWrapper.eq(Users::getPhone, value);
                break;
            // 其他注册类型
            default:
                throw new IllegalArgumentException("Unsupported key: " + key);
        }
        queryWrapper.eq(Users::getState, UserStateEnum.ACTIVE.getCode());

        return usersMapper.selectOne(queryWrapper);
    }


    public int insertUser(Users user) {
        return usersMapper.insert(user);
    }







}
