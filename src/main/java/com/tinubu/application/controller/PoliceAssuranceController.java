package com.tinubu.application.controller;

import com.tinubu.application.model.PoliceAssurance;
import com.tinubu.application.service.PoliceAssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polices")
public class PoliceAssuranceController {

    @Autowired
    private PoliceAssuranceService service;

    @GetMapping
    public List<PoliceAssurance> listerPolices() {
        return service.listerPolices();
    }

    @PostMapping
    public PoliceAssurance creerPolice(@RequestBody PoliceAssurance police) {
        return service.creerPolice(police);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoliceAssurance> lirePolice(@PathVariable Integer id) {
        return service.lirePolice(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PoliceAssurance> editerPolice(@PathVariable Integer id, @RequestBody PoliceAssurance detailsPolice) {
        try {
            PoliceAssurance police = service.editerPolice(id, detailsPolice);
            return ResponseEntity.ok(police);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

