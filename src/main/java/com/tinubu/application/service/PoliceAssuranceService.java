package com.tinubu.application.service;

import com.tinubu.application.model.PoliceAssurance;
import com.tinubu.application.repository.PoliceAssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PoliceAssuranceService {

    @Autowired
    private PoliceAssuranceRepository repository;

    public List<PoliceAssurance> listerPolices() {
        return repository.findAll();
    }

    public PoliceAssurance creerPolice(PoliceAssurance police) {
        police.setDateCreation(new Date());
        police.setDateMiseAJour(new Date());
        return repository.save(police);
    }

    public Optional<PoliceAssurance> lirePolice(Integer id) {
        return repository.findById(id);
    }

    public PoliceAssurance editerPolice(Integer id, PoliceAssurance detailsPolice) {
        PoliceAssurance police = repository.findById(id).orElseThrow();
        police.setNom(detailsPolice.getNom());
        police.setStatus(detailsPolice.getStatus());
        police.setDateDebutCouverture(detailsPolice.getDateDebutCouverture());
        police.setDateFinCouverture(detailsPolice.getDateFinCouverture());
        police.setDateMiseAJour(new Date());
        return repository.save(police);
    }
}
