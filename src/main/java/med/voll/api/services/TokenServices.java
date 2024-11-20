package med.voll.api.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import med.voll.api.domain.users.LoginUsers;

@Service
public class TokenServices {

    @Value("${spring.security.secret}")
    private String apiSecret;

    public String generateToken(LoginUsers loginUsers) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("voll med")
                    .withSubject(loginUsers.getLogin())
                    .withClaim("id", loginUsers.getId())
                    .withExpiresAt(generateExpirit())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    private Instant generateExpirit() {
        return LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
