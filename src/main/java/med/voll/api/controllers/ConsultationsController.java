package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.config.dto.ConsultationsDataDTO;
import med.voll.api.services.ConsultReservService;

@RestController
@RequestMapping("/api/v1/consultations")
@SecurityRequirement(name = "bearer-key")
public class ConsultationsController {

    @Autowired
    private ConsultReservService consultReservService;

    @SuppressWarnings("rawtypes")
    @PostMapping
    @Transactional
    public ResponseEntity reservation(@RequestBody @Valid ConsultationsDataDTO consultationsDataDTO) {

        var consultDetails = consultReservService.reserv(consultationsDataDTO);

        return ResponseEntity.ok(consultDetails);
    }

}
