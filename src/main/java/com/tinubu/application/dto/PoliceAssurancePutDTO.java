package com.tinubu.application.dto;

import java.util.Date;

public class PoliceAssurancePutDTO {
    private String nom;
    private String status;
    private Date dateDebutCouverture;
    private Date dateFinCouverture;

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
}
