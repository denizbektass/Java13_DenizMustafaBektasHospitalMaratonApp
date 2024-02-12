package com.dennis.dto.request;

import com.dennis.entity.enums.EAppointmentState;
import com.dennis.entity.enums.EDepartmant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAppointmentRequestDto {
    private String doctorFirstName;
    private String doctorLastName;
    private Date appointmentDate;
    private EDepartmant departmant;
    private String patientName;
}
