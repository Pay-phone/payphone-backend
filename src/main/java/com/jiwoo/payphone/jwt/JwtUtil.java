package com.jiwoo.payphone.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	private final long expirationMs = 60 * 60 * 1000; //토큰 유효시간(1시간) - 추후 10분으로 줄일 예정(은행권 보안 강화) 
	
	/**
     * JWT 토큰 생성
     * @param userId 사용자 고유 ID
     * @param role 사용자 권한
     * @return 생성된 JWT 토큰
     */
    public String generateToken(Long userId, String role) {
        return Jwts.builder()
                .setSubject(String.valueOf(userId)) // 사용자 고유 ID
                .claim("role", role) // 사용자 권한
                .setIssuedAt(new Date()) // 발급 시간
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs)) // 만료 시간
                .signWith(SignatureAlgorithm.HS512, secretKey) // 서명 알고리즘
                .compact();
    }
	
    /**
     * 토큰 유효성 검증
     * @param token JWT 토큰
     * @return 유효 여부
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
            return true; // 서명과 만료시간이 모두 유효하면 true 반환
        } catch (Exception e) {
            return false; // 유효하지 않은 경우 false
        }
    }
    
    /**
     * 토큰에서 사용자 ID 추출
     * @param token JWT 토큰
     * @return 사용자 고유 ID
     */
    public Long getUserIdFromToken(String token) {
        Claims claims = extractClaims(token);
        return Long.parseLong(claims.getSubject());
    }

    /**
     * 토큰에서 사용자 권한(Role) 추출
     * @param token JWT 토큰
     * @return 사용자 권한
     */
    public String getRoleFromToken(String token) {
        Claims claims = extractClaims(token);
        return claims.get("role", String.class);
    }

    /**
     * 토큰에서 Claims 추출
     * @param token JWT 토큰
     * @return Claims 객체
     */
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    

	

}
