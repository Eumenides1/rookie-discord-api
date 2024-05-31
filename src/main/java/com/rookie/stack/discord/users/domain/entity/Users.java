package com.rookie.stack.discord.users.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.rookie.stack.discord.common.handler.EncryptHandler;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName(value = "users", autoResultMap = true)
@Builder
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
    @TableField(value = "password_hash", typeHandler = EncryptHandler.class)
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
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    // 对入参进行格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 对出参进行格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at", fill = FieldFill.UPDATE)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;


}
