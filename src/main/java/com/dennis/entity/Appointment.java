package com.dennis.entity;

import com.dennis.entity.enums.EAppointmentState;
import com.dennis.entity.enums.EDepartmant;
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
@Table(name = "tbl-appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long doctorId;
    private String patientName;
    private Date appointmentDate;
    @Enumerated(EnumType.STRING)
    private EDepartmant departmant;
    @Enumerated(EnumType.STRING)
    private EAppointmentState state;
}
