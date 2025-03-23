package com.tinubu.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoliceAssurancePutDTO {
    @NotEmpty(message = "Le nom est obligatoire")
    private String nom;


    private String status;

    @NotNull(message = "La date de début de couverture est obligatoire")
    private Date dateDebutCouverture;

    @NotNull(message = "La date de fin de couverture est obligatoire")
    private Date dateFinCouverture;
}
