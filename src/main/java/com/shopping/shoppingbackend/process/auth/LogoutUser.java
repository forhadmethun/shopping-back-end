package com.shopping.shoppingbackend.process.auth;

import com.shopping.shoppingbackend.payload.request.LogOutRequest;
import com.shopping.shoppingbackend.payload.response.MessageResponse;
import com.shopping.shoppingbackend.security.RefreshTokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Component
public class LogoutUser {

    private final RefreshTokenService refreshTokenService;

    public LogoutUser(RefreshTokenService refreshTokenService) {
        this.refreshTokenService = refreshTokenService;
    }

    public MessageResponse logOut(@Valid @RequestBody LogOutRequest logOutRequest) {
        refreshTokenService.deleteByUserId(logOutRequest.getUserId());
        return new MessageResponse("Log out successful!");
    }

}
