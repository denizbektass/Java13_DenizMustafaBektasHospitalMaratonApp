package com.dennis.entity;

import com.dennis.entity.enums.EComplaint;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl-patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    //private String userName;
    private String identityNumber;
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String occupation; //the job of the patient
    private EComplaint ilnessComplaint; //Headache, Stomachache etc.
}
