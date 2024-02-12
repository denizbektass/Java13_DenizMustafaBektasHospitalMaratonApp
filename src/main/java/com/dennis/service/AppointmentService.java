package com.dennis.service;

import com.dennis.dto.request.GetAppointmentRequestDto;
import com.dennis.entity.Appointment;
import com.dennis.entity.Doctor;
import com.dennis.entity.enums.EAppointmentState;
import com.dennis.entity.enums.EDoctorState;
import com.dennis.exception.ErrorType;
import com.dennis.exception.HospitalAppException;
import com.dennis.repository.AppointmentRepository;
import com.dennis.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    public void addAppointment(GetAppointmentRequestDto getAppointmentRequestDto) {
        Optional<Doctor> doctor = doctorService.findOptionalByFirstNameAndLastName(getAppointmentRequestDto.getDoctorFirstName(), getAppointmentRequestDto.getDoctorLastName());
        if(doctor.isEmpty())
            throw new HospitalAppException(ErrorType.ERROR_INVALID_DOCTOR_NAME);
        if(doctor.get().getState().equals(EDoctorState.AVAILABLE)) {
            appointmentRepository.save(Appointment.builder()
                    .doctorId(doctor.get().getId())
                    .departmant(getAppointmentRequestDto.getDepartmant())
                    .state(EAppointmentState.ACTIVE)
                    //TODO AŞAĞIDAKİ KOD DIŞARIDAN PARAMETRE OLARAK DATE ALDIĞI İÇİN HATA VEREBİLİR!!!
                    .appointmentDate(getAppointmentRequestDto.getAppointmentDate())
                    .patientName(getAppointmentRequestDto.getPatientName())
                    .build());
            doctor.get().setState(EDoctorState.NOT_AVAILABLE);
            doctor.get().setAppointmentDate(getAppointmentRequestDto.getAppointmentDate());
            doctor.get().setPatientName(getAppointmentRequestDto.getPatientName());
            doctorService.saveUpdatedDoctor(doctor.get());
        }else {
            throw new HospitalAppException(ErrorType.ERROR_NOT_ACTIVE_DOCTOR);
        }

    }
}
