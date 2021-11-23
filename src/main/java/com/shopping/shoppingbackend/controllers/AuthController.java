package com.shopping.shoppingbackend.controllers;
import com.shopping.shoppingbackend.payload.request.LogOutRequest;
import com.shopping.shoppingbackend.payload.request.LoginRequest;
import com.shopping.shoppingbackend.payload.request.SignupRequest;
import com.shopping.shoppingbackend.payload.request.TokenRefreshRequest;
import com.shopping.shoppingbackend.payload.response.JwtResponse;
import com.shopping.shoppingbackend.payload.response.MessageResponse;
import com.shopping.shoppingbackend.payload.response.TokenRefreshResponse;
import com.shopping.shoppingbackend.process.auth.AuthenticateUser;
import com.shopping.shoppingbackend.process.auth.LogoutUser;
import com.shopping.shoppingbackend.process.auth.RefreshToken;
import com.shopping.shoppingbackend.process.auth.RegisterUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthenticateUser authenticateUser;
  private final LogoutUser logoutUser;
  private final RefreshToken refreshToken;
  private final RegisterUser registerUser;

  public AuthController(
      AuthenticateUser authenticateUser,
      LogoutUser logoutUser,
      RefreshToken refreshToken,
      RegisterUser registerUser) {
    this.authenticateUser = authenticateUser;
    this.logoutUser = logoutUser;
    this.refreshToken = refreshToken;
    this.registerUser = registerUser;
  }

  @PostMapping("/signin")
  public ResponseEntity<JwtResponse> authenticateUser(
      @Valid @RequestBody LoginRequest loginRequest) {
    return ResponseEntity.ok(authenticateUser.authenticate(loginRequest));
  }

  @PostMapping("/signup")
  public ResponseEntity<MessageResponse> registerUser(
      @Valid @RequestBody SignupRequest signUpRequest) {
    return ResponseEntity.ok(registerUser.register(signUpRequest));
  }

  @PostMapping("/refreshtoken")
  public ResponseEntity<TokenRefreshResponse> refreshToken(
      @Valid @RequestBody TokenRefreshRequest request) {
    return ResponseEntity.ok(refreshToken.refresh(request));
  }
  
  @PostMapping("/logout")
  public ResponseEntity<MessageResponse> logoutUser(@Valid @RequestBody LogOutRequest logOutRequest) {
    return ResponseEntity.ok(logoutUser.logOut(logOutRequest));
  }

}
