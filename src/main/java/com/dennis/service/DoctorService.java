package com.dennis.service;

import com.dennis.dto.request.AddDoctorRequestDto;
import com.dennis.dto.request.UpdateDoctorStateRequestDto;
import com.dennis.dto.response.GetDoctorInfoResponseDto;
import com.dennis.entity.Doctor;
import com.dennis.entity.enums.EAppointmentState;
import com.dennis.entity.enums.EDoctorState;
import com.dennis.exception.ErrorType;
import com.dennis.exception.HospitalAppException;
import com.dennis.mapper.GetDoctorInfoResponseDtoMapper;
import com.dennis.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    public void save(AddDoctorRequestDto addDoctorRequestDto) {
        doctorRepository.save(Doctor.builder()
                        .firstName(addDoctorRequestDto.getFirstName())
                        .lastName(addDoctorRequestDto.getLastName())
                        .address(addDoctorRequestDto.getAddress())
                        .specialty(addDoctorRequestDto.getSpecialty())
                        .departmant(addDoctorRequestDto.getDepartmant())
                        .title(addDoctorRequestDto.getTitle())
                        .state(addDoctorRequestDto.getState())
                .build());
    }

    public List<GetDoctorInfoResponseDto> getDoctorInfo() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<GetDoctorInfoResponseDto> getDoctorInfoResponseDtos = new ArrayList<>();
        doctors.forEach(doctor -> {
            getDoctorInfoResponseDtos.add(
                    GetDoctorInfoResponseDtoMapper.INSTANCE.fromDoctor(doctor)
            );
        });
        return getDoctorInfoResponseDtos;
    }

    public Optional<Doctor> findOptionalByFirstNameAndLastName(String doctorFirstName, String doctorLastName) {
        return doctorRepository.findOptionalByFirstNameAndLastName(doctorFirstName, doctorLastName);
    }

    public void saveUpdatedDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public void updateDoctorState(UpdateDoctorStateRequestDto updateDoctorStateRequestDto) {
        Optional<Doctor> doctor = doctorRepository.findOptionalByFirstNameAndLastName(updateDoctorStateRequestDto.getFirstName(), updateDoctorStateRequestDto.getLastName());
        if(doctor.isEmpty())
            throw new HospitalAppException(ErrorType.ERROR_INVALID_DOCTOR_ID);
        Doctor updatedDoctor = doctor.get();
        updatedDoctor.setState(updateDoctorStateRequestDto.getDoctorState());
        updatedDoctor.setPatientName(null);
        updatedDoctor.setAppointmentDate(null);
        doctorRepository.save(updatedDoctor);
    }
}
