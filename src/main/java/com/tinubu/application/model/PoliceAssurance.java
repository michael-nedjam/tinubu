package com.tinubu.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PoliceAssurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Date dateDebutCouverture;

    @Column(nullable = false)
    private Date dateFinCouverture;

    @Column(nullable = false, updatable = false)
    private Date dateCreation;

    @Column(nullable = false)
    private Date dateMiseAJour;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
