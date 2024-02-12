package com.dennis.dto.request;

import com.dennis.entity.enums.EDoctorState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDoctorStateRequestDto {
    private EDoctorState doctorState;
    private String firstName;
    private String lastName;
}
