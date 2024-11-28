package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.config.dto.RegisterPatiensDTO;
import med.voll.api.domain.patients.PatientsModel;
import med.voll.api.repository.PatientsRepository;

@RestController
@RequestMapping("/api/v1/patients")
@SecurityRequirement(name = "bearer-key")

public class PatientsController {

    @Autowired
    private PatientsRepository patientsRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RegisterPatiensDTO patiens) {
        patientsRepository.save(new PatientsModel(patiens));

    }

}
