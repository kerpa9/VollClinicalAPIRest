package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.config.dto.DetailsConsultations;
import med.voll.api.services.ConsultReservService;

@RestController
@RequestMapping("/api/v1/consultations")
public class ConsultationsController {

    @Autowired
    private ConsultReservService consultReservService;

    @PostMapping
    @Transactional
    public ResponseEntity reservation (@RequestBody @Valid ConsultationsDataDTO consultationsDataDTO){

        consultReservService.reserv(consultationsDataDTO);
        System.out.println(consultationsDataDTO);
        return ResponseEntity.ok(new DetailsConsultations(null, null, null, null));
    }

    
}
