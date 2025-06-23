package com.riderspoint.auth_service.utility;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtService {
	
	private final String SECRET = "riders_point_@jwt$2025_secure_key_string_random_786";
	private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8)); // or load from env/config

    private static final long EXPIRATION_MS = 1000 * 60 * 30; // 1 hour

    public String generateToken(String subject) {
    	log.info("Key : {}", SECRET);
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(key)
                .compact();
    }

//    public String extractSubject(String token) {
//    	try {
//        String subject = Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//        return subject;
//    	}
//    	catch(ExpiredJwtException e) {
//    		return e.getMessage();
//    	}
//    }
//
//    public boolean isTokenValid(String token) {
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
}
