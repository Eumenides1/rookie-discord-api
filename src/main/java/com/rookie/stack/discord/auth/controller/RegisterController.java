package com.rookie.stack.discord.auth.controller;

import com.rookie.stack.discord.common.domain.vo.resp.ApiResult;
import com.rookie.stack.discord.auth.domain.vo.resp.RegistrationResponse;
import com.rookie.stack.discord.auth.RegisterService;
import com.rookie.stack.discord.auth.RegistrationDetails;
import com.rookie.stack.discord.auth.factory.RegistrationServiceFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Resource
    private RegistrationServiceFactory registrationServiceFactory;

    @PostMapping
    public ApiResult<RegistrationResponse> register(@Valid @RequestBody RegistrationDetails details,
                                                    HttpServletRequest request){
        RegisterService registrationService = registrationServiceFactory.getRegistrationService(details.getType());
        RegistrationResponse response = registrationService.register(details);
        return ApiResult.success(response);
    }



}
