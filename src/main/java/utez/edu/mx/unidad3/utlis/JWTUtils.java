package utez.edu.mx.unidad3.utlis;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.function.Function;

public class JWTUtils {

    @Value("${secret.key}")
    private String SECRET_KEY;

    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJwt(token)
                .getBody();
    }

    ;

    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {

        final Claims CLAIMS = extractClaims(token);
        return claimsResolver.apply(CLAIMS);

    }

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);

    }

    public Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

}
