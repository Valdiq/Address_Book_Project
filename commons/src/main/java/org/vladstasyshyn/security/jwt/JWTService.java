package org.vladstasyshyn.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import org.vladstasyshyn.security.user.UserEntity;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private static final String SECRET_KEY = "cae242bcf796dd318cd6963e8f116dea19c190d7c558d789b2b1ef935c2c978c";

    public String generateToken(UserEntity userEntity) {
        return generateToken(new HashMap<>(), userEntity);
    }

    public String generateToken(Map<String, Object> extraClaims, UserEntity userEntity) {
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userEntity.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignOInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignOInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignOInKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public Date extractExpirationDate(String token) {
        return extractAllClaims(token).getExpiration();
    }

    public boolean isTokenValid(String token, UserEntity userEntity) {
        final String username = extractUsername(token);
        return (username.equals(userEntity.getUsername())) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date());
    }


}
