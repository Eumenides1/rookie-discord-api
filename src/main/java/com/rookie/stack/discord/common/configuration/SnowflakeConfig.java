package com.rookie.stack.discord.common.configuration;

import cn.hutool.core.lang.Snowflake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@Configuration
public class SnowflakeConfig {
    @Bean
    public Snowflake snowflake(){
        return new Snowflake();
    }

}
