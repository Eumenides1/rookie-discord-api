package com.rookie.stack.discord.common.handler;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class EncryptHandler extends BaseTypeHandler<String> {

    /**
     * 线上运行后勿修改，会影响已加密数据解密
     */
    private static final byte[] KEYS = "jaguar831143abcd".getBytes(StandardCharsets.UTF_8);

    /**
     * 创建AES实例，确保填充方式和编码方式一致
     */
    private static final AES AES_INSTANCE = SecureUtil.aes(KEYS);

    /**
     * 设置参数
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        if (StringUtils.isEmpty(parameter)) {
            ps.setString(i, null);
            return;
        }
        String encrypt = AES_INSTANCE.encryptBase64(parameter); // 使用Base64编码
        ps.setString(i, encrypt);
    }

    /**
     * 获取值
     */
    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if ("password_hash".equals(columnName)) {
            return decrypt(rs.getString(columnName));
        }
        return rs.getString(columnName);
    }

    /**
     * 获取值
     */
    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return decrypt(rs.getString(columnIndex));
    }

    /**
     * 获取值
     */
    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return decrypt(cs.getString(columnIndex));
    }

    private String decrypt(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        try {
            return AES_INSTANCE.decryptStr(value); // 直接解密Base64编码的数据
        } catch (Exception e) {
            throw new RuntimeException("Failed to decrypt value", e);
        }
    }
}
