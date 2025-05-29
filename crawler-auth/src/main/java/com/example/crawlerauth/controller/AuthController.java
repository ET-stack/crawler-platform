package com.example.crawlerauth.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.crawlerauth.dto.LoginRequest;
import com.example.crawlerauth.entity.User;
import com.example.crawlerauth.mapper.UserMapper;
import com.example.crawlerauth.security.JwtTokenProvider;
import com.example.crawlerauth.vo.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    private final UserMapper userMapper;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PreAuthorize("hasAuthority('user:list')")
    @GetMapping("/user/list")
    public Page<User> listUsers() {
        return userMapper.selectPage(Page.of(1, 10), null);
    }
}
