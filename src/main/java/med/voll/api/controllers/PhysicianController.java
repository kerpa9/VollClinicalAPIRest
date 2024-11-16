package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dtos.RegisterPhysicianDTO;
import med.voll.api.physician.PhysicianModel;
import med.voll.api.physician.PhysicianRepository;

@RestController
@RequestMapping("/api/v1/physician")

public class PhysicianController {

    @Autowired
    private PhysicianRepository physicianRepository;

    @PostMapping
    public void registerPhysician(@RequestBody RegisterPhysicianDTO parameter) {
        physicianRepository.save(new PhysicianModel(parameter));

    }

}
