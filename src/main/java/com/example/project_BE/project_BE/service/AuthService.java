package com.example.project_BE.project_BE.service;

import com.example.project_BE.project_BE.detail.AdminDetail;
import com.example.project_BE.project_BE.detail.CustomUserDetails;
import com.example.project_BE.project_BE.model.Admin;
import com.example.project_BE.project_BE.model.LoginRequest;
import com.example.project_BE.project_BE.repository.AdminRepository;
import com.example.project_BE.project_BE.securityNew.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService  {
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    CustomUserDetails customUserDetails;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Admin> adminOptional = adminRepository.findByEmail(username);
        if (adminOptional.isPresent()) {
            return AdminDetail.buildAdmin(adminOptional.get());
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }


    public Map<String, Object> authenticate(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        UserDetails userDetails = loadUserByUsername(email);

        if (!passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException("Email atau password yang Anda masukkan salah");
        }

        // Generate token after successful authentication
        String token = jwtTokenUtil.generateToken(userDetails);

        Map<String, Object> response = new HashMap<>();
        response.put("data", userDetails);
        response.put("token", token);
        return response;
    }

}