package com.dennis.service;

import com.dennis.dto.request.GetAppointmentRequestDto;
import com.dennis.dto.request.UpdateRequestDto;
import com.dennis.entity.Appointment;
import com.dennis.entity.Patient;
import com.dennis.exception.ErrorType;
import com.dennis.exception.HospitalAppException;
import com.dennis.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final AppointmentService appointmentService;

    public Patient save(String identityNumber, String password) {
        try {
            return patientRepository.save(Patient.builder()
                    .identityNumber(identityNumber)
                    .password(password)
                    .build());
        }catch (HospitalAppException hospitalAppException) {
            throw new HospitalAppException(ErrorType.ERROR_DUPLICATE_IDENTITY_NUMBER);
        }



    }
    public void update(UpdateRequestDto updateRequestDto) {
        patientRepository.save(Patient.builder()
                        .email(updateRequestDto.getEmail())
                        .firstName(updateRequestDto.getFirstName())
                        .lastName(updateRequestDto.getLastName())
                        .password(updateRequestDto.getPassword())
                        .occupation(updateRequestDto.getOccupation())
                .build());
    }

    public void addAppointment(GetAppointmentRequestDto getAppointmentRequestDto) {
        appointmentService.addAppointment(getAppointmentRequestDto);
    }
}
