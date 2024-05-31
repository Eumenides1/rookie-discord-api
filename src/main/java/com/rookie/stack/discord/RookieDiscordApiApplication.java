package com.rookie.stack.discord;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author eumenides
 */
@SpringBootApplication(scanBasePackages = {"com.rookie.stack.discord"})
@MapperScan({"com.rookie.stack.discord.**.mapper"})
public class RookieDiscordApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RookieDiscordApiApplication.class, args);
    }

}
