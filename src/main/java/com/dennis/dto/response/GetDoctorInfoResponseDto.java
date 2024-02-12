package com.dennis.dto.response;

import com.dennis.entity.enums.EDoctorState;
import com.dennis.entity.enums.ESpecialty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetDoctorInfoResponseDto {
    private EDoctorState state;
    private String patientName;
    private Date appointmentDate;
    private ESpecialty specialty;
    private String firstName;
    private String lastName;

}
