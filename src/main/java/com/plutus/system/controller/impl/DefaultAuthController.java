package com.plutus.system.controller.impl;

import com.plutus.system.controller.AuthController;
import com.plutus.system.model.request.auth.ATMTokenRequest;
import com.plutus.system.model.request.auth.AdminTokenRequest;
import com.plutus.system.model.response.TokenInfo;
import com.plutus.system.service.AuthorizationService;
import com.plutus.system.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DefaultAuthController implements AuthController {

    private final AuthorizationService service;
    private final JwtTokenService jwtTokenService;

    @Override
    public TokenInfo getTokenForATM(ATMTokenRequest tokenRequest) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(tokenRequest.getAccountNumber(), tokenRequest.getPin());
        Authentication authorized = service.generateAuthorizationToken(authToken);
        return new TokenInfo(jwtTokenService.getTokenFromAuthentication(authorized));
    }

    @Override
    public TokenInfo getTokenForAdmin(AdminTokenRequest tokenRequest) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(tokenRequest.getLogin(), tokenRequest.getPassword());
        Authentication authorized = service.generateAuthorizationToken(authToken);
        return new TokenInfo(jwtTokenService.getTokenFromAuthentication(authorized));
    }
}
