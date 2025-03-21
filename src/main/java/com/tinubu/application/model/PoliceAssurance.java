package com.tinubu.application.model;

import jakarta.persistence.*;
import java.util.Date;

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

    // Getters et Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDateDebutCouverture() {
        return dateDebutCouverture;
    }

    public void setDateDebutCouverture(Date dateDebutCouverture) {
        this.dateDebutCouverture = dateDebutCouverture;
    }

    public Date getDateFinCouverture() {
        return dateFinCouverture;
    }

    public void setDateFinCouverture(Date dateFinCouverture) {
        this.dateFinCouverture = dateFinCouverture;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(Date dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    public enum Status {
        ACTIVE, INACTIVE
    }
}
