package com.rookie.stack.discord.users.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author jaguarliu
 * @since 2024-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户自增主键 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户唯一识别 ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 用户密码
     */
    @TableField("password_hash")
    private String passwordHash;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 用户手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 用户头像
     */
    @TableField("avatar_url")
    private String avatarUrl;

    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 用户简介/描述/自我介绍
     */
    @TableField("bio")
    private String bio;

    /**
     * 用户性别
     */
    @TableField("gender")
    private String gender;

    /**
     * 用户生日
     */
    @TableField("birthdate")
    private Date birthdate;

    /**
     * 注册 IP 地址
     */
    @TableField("local_addr")
    private String localAddr;

    /**
     * 用户状态
     */
    @TableField("state")
    private Integer state;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private Date createdAt;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    private Date updatedAt;


}
