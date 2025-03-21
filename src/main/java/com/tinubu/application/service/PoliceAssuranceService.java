package com.tinubu.application.service;

import com.tinubu.application.model.PoliceAssurance;
import com.tinubu.application.repository.PoliceAssuranceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PoliceAssuranceService {

    private static final Logger logger = LoggerFactory.getLogger(PoliceAssuranceService.class);

    @Autowired
    private PoliceAssuranceRepository repository;

    public List<PoliceAssurance> listerPolices() {
        return repository.findAll();
    }

    public PoliceAssurance creerPolice(String nom, PoliceAssurance.Status status, Date dateDebutCouverture, Date dateFinCouverture) {
        PoliceAssurance police = new PoliceAssurance();
        police.setNom(nom);
        police.setStatus(status);
        police.setDateDebutCouverture(dateDebutCouverture);
        police.setDateFinCouverture(dateFinCouverture);
        police.setDateCreation(new Date());
        police.setDateMiseAJour(new Date());
        police = repository.save(police);

        logger.info("Création d'une police d’assurance, id: {}", police.getId());

        return police;
    }

    public Optional<PoliceAssurance> lirePolice(Integer id) {
        return repository.findById(id);
    }

    public PoliceAssurance editerPolice(Integer id, String nom, PoliceAssurance.Status status, Date dateDebutCouverture, Date dateFinCouverture) {
        logger.info("Edition d'une police d’assurance, id: {}", id);

        PoliceAssurance police = repository.findById(id).orElseThrow();
        police.setNom(nom);
        police.setStatus(status);
        police.setDateDebutCouverture(dateDebutCouverture);
        police.setDateFinCouverture(dateFinCouverture);
        police.setDateMiseAJour(new Date());
        return repository.save(police);
    }
}
