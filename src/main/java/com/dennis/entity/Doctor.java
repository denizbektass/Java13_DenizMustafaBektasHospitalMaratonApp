package com.dennis.entity;

import com.dennis.entity.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientName;
    private Date appointmentDate;
    private String firstName;
    private String lastName;
    private String address;
    @Enumerated(EnumType.STRING)
    private ESpecialty specialty; //This variable indicate the specialty of the doctor like brain surgery or orthopedics etc.
    @Enumerated(EnumType.STRING)
    private EDepartmant departmant;
    @Enumerated(EnumType.STRING)
    private ETitle title;
    private EDoctorState state;
}
