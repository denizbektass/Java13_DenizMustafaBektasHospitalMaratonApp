package com.dennis.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRequestDto {
    //private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String occupation;
}
