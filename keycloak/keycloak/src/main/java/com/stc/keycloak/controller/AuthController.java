package com.stc.keycloak.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AuthController {

    @GetMapping("/whoami")
    public ResponseEntity<Map<String, Object>> whoAmI(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();

        Map<String, Object> response = new HashMap<>();
        response.put("username", jwt.getClaimAsString("preferred_username"));
        response.put("email", jwt.getClaimAsString("email"));
        response.put("roles", jwt.getClaimAsStringList("roles"));
        response.put("firstName", jwt.getClaimAsString("given_name"));
        response.put("lastName", jwt.getClaimAsString("family_name"));
        response.put("authorities", authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return ResponseEntity.ok(response);
    }
}