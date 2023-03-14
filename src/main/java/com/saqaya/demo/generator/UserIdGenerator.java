package com.saqaya.demo.generator;

import com.saqaya.demo.entity.UserEntity;
import com.saqaya.demo.util.SecurityUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public class UserIdGenerator implements IdentifierGenerator {

    @Value("${salt-key}")
    private String saltKey;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object obj) throws HibernateException {
        UserEntity userEntity = (UserEntity) obj;
        return SecurityUtils.getSecureId(userEntity.getEmail(), saltKey.getBytes());
    }
}
