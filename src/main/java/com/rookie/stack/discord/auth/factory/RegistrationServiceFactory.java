package com.rookie.stack.discord.auth.factory;

import com.rookie.stack.discord.auth.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@Component
public class RegistrationServiceFactory {

    private final Map<String, RegisterService> registrationServiceMap;

    @Autowired
    public RegistrationServiceFactory(Map<String, RegisterService> registrationServiceMap) {
        this.registrationServiceMap = registrationServiceMap;
    }

    public RegisterService getRegistrationService(String registrationType) {
        RegisterService service = registrationServiceMap.get(registrationType + "RegistrationServiceImpl");
        if (service == null) {
            throw new IllegalArgumentException("Unsupported registration type: " + registrationType);
        }
        return service;
    }
}
