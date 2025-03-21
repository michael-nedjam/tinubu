package com.tinubu.application.controller;

import com.tinubu.application.dto.PoliceAssurancePostDTO;
import com.tinubu.application.dto.PoliceAssurancePutDTO;
import com.tinubu.application.dto.PoliceAssuranceDTO;
import com.tinubu.application.model.PoliceAssurance;
import com.tinubu.application.service.PoliceAssuranceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/polices")
public class PoliceAssuranceController {

    @Autowired
    private PoliceAssuranceService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<PoliceAssuranceDTO> listerPolices() {
        return service.listerPolices().stream()
                .map(police -> modelMapper.map(police, PoliceAssuranceDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public PoliceAssuranceDTO creerPolice(@RequestBody PoliceAssurancePostDTO policeDTO) {
        PoliceAssurance police = service.creerPolice(
                policeDTO.getNom(),
                PoliceAssurance.Status.valueOf(policeDTO.getStatus()),
                policeDTO.getDateDebutCouverture(),
                policeDTO.getDateFinCouverture()
        );
        return modelMapper.map(police, PoliceAssuranceDTO.class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoliceAssuranceDTO> lirePolice(@PathVariable Integer id) {
        return service.lirePolice(id)
                .map(police -> ResponseEntity.ok(modelMapper.map(police, PoliceAssuranceDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PoliceAssuranceDTO> editerPolice(@PathVariable Integer id, @RequestBody PoliceAssurancePutDTO policeDTO) {
        try {
            PoliceAssurance police = service.editerPolice(
                    id,
                    policeDTO.getNom(),
                    PoliceAssurance.Status.valueOf(policeDTO.getStatus()),
                    policeDTO.getDateDebutCouverture(),
                    policeDTO.getDateFinCouverture()
            );
            return ResponseEntity.ok(modelMapper.map(police, PoliceAssuranceDTO.class));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
