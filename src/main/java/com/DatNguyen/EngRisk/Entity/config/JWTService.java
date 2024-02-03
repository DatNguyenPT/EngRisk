package com.DatNguyen.EngRisk.Entity.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {
    // Extract claim, extract email, compare with SECURE_KEY
    private static final String SECURE_KEY = "11539B63B4F1D377E931DEF17E275"; // 256 -bit hash
    private Claims extractAllClaims(String jwtToken){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJwt(jwtToken)
                .getBody();
    }
    public <T>T extractClaim(String jwtToken, Function<Claims, T>claimResolver){
        final Claims claims = extractAllClaims(jwtToken);
        return claimResolver.apply(claims);
    }


    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECURE_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserEmail(String jwtToken){
        return extractClaim(jwtToken, Claims::getSubject);
    }

    // Token generator, check token validation
    public String tokenGenerator(CustomUserDetails customUserDetails){
        return tokenGenerator(new HashMap<>(), customUserDetails);
    }
    public String tokenGenerator(Map<String, Object>extraClaims, CustomUserDetails customUserDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(customUserDetails.getEmail()) // Check the email
                // Check if the token is expired, valid or not
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24)) // 24 hours
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // Algorithm for 256-bit hash
                .compact(); // Generate and return token
    }
    public Date extractExpiration(String jwtToken){
        return extractClaim(jwtToken, Claims::getExpiration);
    }

    public boolean isExpiredToken(String jwtToken){
        return extractExpiration(jwtToken).before(new Date());
    }
    public boolean isTokenValidate(String jwtToken, CustomUserDetails customUserDetails){
        String userEmail = extractUserEmail(jwtToken);
        return userEmail.equals(customUserDetails.getEmail()) && !isExpiredToken(jwtToken);
    }
}
