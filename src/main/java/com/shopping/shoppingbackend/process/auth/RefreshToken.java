package com.shopping.shoppingbackend.process.auth;

import com.shopping.shoppingbackend.exception.TokenRefreshException;
import com.shopping.shoppingbackend.payload.request.TokenRefreshRequest;
import com.shopping.shoppingbackend.payload.response.TokenRefreshResponse;
import com.shopping.shoppingbackend.security.RefreshTokenService;
import com.shopping.shoppingbackend.security.jwt.JwtUtils;
import org.springframework.stereotype.Component;

@Component
public class RefreshToken {

    private final JwtUtils jwtUtils;
    private final RefreshTokenService refreshTokenService;

    public RefreshToken(JwtUtils jwtUtils, RefreshTokenService refreshTokenService) {
        this.jwtUtils = jwtUtils;
        this.refreshTokenService = refreshTokenService;
    }

    public TokenRefreshResponse refresh(TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();
        return refreshTokenService.findByToken(requestRefreshToken)
            .map(refreshTokenService::verifyExpiration)
            .map(com.shopping.shoppingbackend.models.RefreshToken::getUser)
            .map(user -> {
                String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                return new TokenRefreshResponse(token, requestRefreshToken);
            })
            .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                "Refresh token is not in database!"));
    }
}
