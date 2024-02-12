package com.dennis.controller;

import com.dennis.dto.request.AddDoctorRequestDto;
import com.dennis.dto.request.UpdateDoctorStateRequestDto;
import com.dennis.dto.response.GetDoctorInfoResponseDto;
import com.dennis.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.dennis.constants.RestApiUrls.*;

@RestController
@RequestMapping(DOCTOR)
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    @PostMapping(value = ADD, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> addDoctor(@RequestBody @ModelAttribute AddDoctorRequestDto addDoctorRequestDto){
        doctorService.save(addDoctorRequestDto);
        return ResponseEntity.ok(true);
    }
    @GetMapping(GET_ALL)
    public ResponseEntity<List<GetDoctorInfoResponseDto>> getDoctorInfo(){
        return ResponseEntity.ok(doctorService.getDoctorInfo());
    }
    @PostMapping(value = UPDATE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> updateDoctorState(@RequestBody @ModelAttribute UpdateDoctorStateRequestDto updateDoctorStateRequestDto) {
        doctorService.updateDoctorState(updateDoctorStateRequestDto);
        return ResponseEntity.ok(true);
    }
}
