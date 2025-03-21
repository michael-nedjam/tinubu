package com.tinubu.application.dto;

import java.util.Date;

public class PoliceAssuranceDTO {
    private Integer id;
    private String nom;
    private String status;
    private Date dateDebutCouverture;
    private Date dateFinCouverture;
    private Date dateCreation;
    private Date dateMiseAJour;

    public PoliceAssuranceDTO() {}

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
}

