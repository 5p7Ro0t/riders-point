package com.riderspoint.user_service.utility;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtService {
	
	private final String SECRET = "riders_point_@jwt$2025_secure_key_string_random_786";
	private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8)); // or load from env/config


    public String extractSubject(String token) {
    	try {
        String subject = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return subject;
    	}
    	catch(ExpiredJwtException e) {
    		return e.getMessage();
    	}
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
