package com.tinubu.application.dto;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoliceAssuranceDTO {
    private Integer id;
    private String nom;
    private String status;
    private Date dateDebutCouverture;
    private Date dateFinCouverture;
    private Date dateCreation;
    private Date dateMiseAJour;
}

