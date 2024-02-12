package com.dennis.service;

import com.dennis.dto.request.LoginRequestDto;
import com.dennis.entity.Auth;
import com.dennis.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    /*
    public Optional<Auth> findOptionalByUserNameAndPassword(String userName, String password) {
        return authRepository.findOptionalByUserNameAndPassword(userName, password);
    }

     */
    /*

    public Auth save(LoginRequestDto loginRequestDto) {
        return authRepository.save(Auth.builder()
                .userName(loginRequestDto.getUserName())
                .password(loginRequestDto.getPassword())
                .email(loginRequestDto.getEmail())
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .isActive(true)
                .build());
    }

     */
}
