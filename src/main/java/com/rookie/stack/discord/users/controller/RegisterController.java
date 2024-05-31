package com.rookie.stack.discord.users.controller;

import com.rookie.stack.discord.common.domain.vo.resp.ApiResult;
import com.rookie.stack.discord.users.domain.vo.req.register.EmailRegistrationDetails;
import com.rookie.stack.discord.users.domain.vo.req.register.GithubRegistrationDetails;
import com.rookie.stack.discord.users.domain.vo.req.register.PhoneRegistrationDetails;
import com.rookie.stack.discord.users.domain.vo.resp.RegistrationResponse;
import com.rookie.stack.discord.users.service.RegisterService;
import com.rookie.stack.discord.users.service.register.RegistrationDetails;
import com.rookie.stack.discord.users.service.register.factory.RegistrationServiceFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public ApiResult<RegistrationResponse> register(@RequestBody RegistrationDetails details,
                                                    HttpServletRequest request){
        RegisterService registrationService = registrationServiceFactory.getRegistrationService(details.getType());

        RegistrationResponse response = registrationService.register(details);
        return ApiResult.success(response);
    }



}
