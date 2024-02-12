package com.dennis.controller;

import com.dennis.dto.request.GetAppointmentRequestDto;
import com.dennis.dto.request.UpdateRequestDto;
import com.dennis.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.dennis.constants.RestApiUrls.*;

@RestController
@RequestMapping(PATIENT)
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(UpdateRequestDto updateRequestDto){
        patientService.update(updateRequestDto);
        return ResponseEntity.ok(true);
    }
    @PostMapping(value = APPOINTMENT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> getAppointment(@RequestBody @ModelAttribute GetAppointmentRequestDto getAppointmentRequestDto) {
        patientService.addAppointment(getAppointmentRequestDto);
        return ResponseEntity.ok(true);
    }
}
