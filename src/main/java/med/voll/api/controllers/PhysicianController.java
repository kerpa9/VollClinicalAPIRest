package med.voll.api.controllers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dtos.RegisterPhysicianDTO;


@RestController
@RequestMapping("/api/v1/physician")
public class PhysicianController {

    @PostMapping
    public void registerPhysician(@RequestBody RegisterPhysicianDTO parameter){
        System.out.println("Create physycian");
        System.out.println(parameter.address());

    }
    
}
