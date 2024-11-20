package med.voll.api.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

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

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException("Token is null");

        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("voll med")
                    .build()
                    .verify(token);
            return verifier.getSubject();

        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }

        if (verifier.getSubject() == null) {
            throw new RuntimeException("Invalid Verifier");
        }
        return verifier.getSubject();

    }

    private Instant generateExpirit() {
        return LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
