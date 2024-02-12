package com.dennis.dto.request;

import com.dennis.entity.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddDoctorRequestDto {
    private String firstName;
    private String lastName;
    private String address;
    private ESpecialty specialty;
    private EDepartmant departmant;
    private ETitle title;
    private EDoctorState state;
}
