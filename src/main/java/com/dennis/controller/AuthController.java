package com.dennis.controller;

import com.dennis.dto.request.LoginRequestDto;
import com.dennis.service.AuthService;
import com.dennis.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dennis.constants.RestApiUrls.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final PatientService patientService;
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto loginRequestDto){
        patientService.save(loginRequestDto.getIdentityNumber(), loginRequestDto.getPassword());
        return ResponseEntity.ok(true);
    }
}
