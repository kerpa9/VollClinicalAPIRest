package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.physician.PhysicianModel;
import med.voll.api.physician.PhysicianRepository;
import med.voll.api.physician.RegisterPhysicianDTO;

@RestController
@RequestMapping("/api/v1/physician")

public class PhysicianController {

    @Autowired
    private PhysicianRepository physicianRepository;

    @PostMapping
    public void registerPhysician(@RequestBody @Valid RegisterPhysicianDTO parameter) {
        physicianRepository.save(new PhysicianModel(parameter));

    }

}
