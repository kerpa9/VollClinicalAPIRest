package med.voll.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.config.dto.DataLoginDTO;
import med.voll.api.config.dto.DatosJWTTokenDTO;
import med.voll.api.domain.users.LoginUsers;
import med.voll.api.services.TokenServices;

@RestController
@RequestMapping("/api/v1/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServices tokenServices;

    @PostMapping
    public ResponseEntity autenticationUser(@RequestBody @Valid DataLoginDTO dataLoginDTO) {

        Authentication token = new UsernamePasswordAuthenticationToken(dataLoginDTO.login(), dataLoginDTO.password());
        var userAuth = authenticationManager.authenticate(token);
        var jwtToken = tokenServices.generateToken((LoginUsers) userAuth.getPrincipal());
        return ResponseEntity.ok(new DatosJWTTokenDTO(jwtToken));

    }

}
