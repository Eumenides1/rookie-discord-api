package com.rookie.stack.discord.common.utils;

import com.rookie.stack.discord.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author eumenides
 * @description
 * @date 2024/6/1
 */
@Component
@Slf4j
public class Ip2RegionUtil {

    private Searcher searcher;

    @PostConstruct
    public void init() {
        try {
            InputStream inputStream = new ClassPathResource("static/ip2region.xdb").getInputStream();
            byte[] bytes = inputStream.readAllBytes();
            searcher = Searcher.newWithBuffer(bytes);
        } catch (IOException e) {
            log.error("Failed to load IP region file", e);
            throw new BusinessException(String.format("Failed to initialize Ip2RegionUtil, {}", e.getMessage()));
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            if (Objects.nonNull(searcher)) {
                searcher.close();
            }
        } catch (Exception e) {
            log.error("Failed to close Searcher", e);
        }
    }

    /**
     * 根据ip地址直接返回国家、省、城市信息
     *
     * @param ip ip
     * @return 返回地址
     */
    public String changeIpToAddress(String ip) {
        try {
            return searcher.search(ip);
        } catch (Exception e) {
            log.error(String.format("ip转地址报错: %s", e.getMessage()), e);
            return "";
        }
    }

}
