package com.rookie.stack.discord.users.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 登录日志表
 * </p>
 *
 * @author jaguarliu
 * @since 2024-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("login_logs")
public class LoginLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    @TableField("user_id")
    private String userId;

    @TableField("login_ip")
    private String loginIp;

    @TableField("login_time")
    private LocalDateTime loginTime;


}
