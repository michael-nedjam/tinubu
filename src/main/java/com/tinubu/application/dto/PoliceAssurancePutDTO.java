package com.tinubu.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoliceAssurancePutDTO {
    private String nom;
    private String status;
    private Date dateDebutCouverture;
    private Date dateFinCouverture;
}
