package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.ListDataPhysicianDTO;
import med.voll.api.dto.RegisterPhysicianDTO;
import med.voll.api.physician.PhysicianModel;
import med.voll.api.repository.PhysicianRepository;

@RestController
@RequestMapping("/api/v1/physician")

public class PhysicianController {

    @Autowired
    private PhysicianRepository physicianRepository;

    @PostMapping
    public void registerPhysician(@RequestBody @Valid RegisterPhysicianDTO parameter) {
        physicianRepository.save(new PhysicianModel(parameter));

    }

    // Overriding pageable values @PageableDefault(size = 2, ...)
    @GetMapping
    public Page<ListDataPhysicianDTO> listPthysician(@PageableDefault(size = 2) Pageable pageable) {
        return physicianRepository.findAll(pageable).map(ListDataPhysicianDTO::new);

    }

    
    @PutMapping
    public void updatePhysician(){}


}
