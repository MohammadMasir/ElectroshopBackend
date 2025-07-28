package com.electroshop.electroshop_backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

	@Value("${security.jwt.secret-key}")
	private String secretKey;

	@Value("${security.jwt.expiration-time}")
	private long expirationTime;

	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(),userDetails);
	}

	private String generateToken(HashMap<String,Object> extraClaims, UserDetails userDetails) {
		return buildToken(extraClaims, userDetails, expirationTime);
	}

	private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, Long expirationTime){
		return Jwts.builder()
				.addClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
				.signWith(getSigningKeyBytes(), SignatureAlgorithm.HS256)
				.compact();
	}

	// Generic claim extractor (validates signature)
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
			final Claims claims = extractAllClaims(token);
			return claimsResolver.apply(claims);
	}

	// Consistent specific extractors
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public Date extractIssuedAt(String token) {
		return extractClaim(token, Claims::getIssuedAt);
	}

	// Signature validation happens here
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKeyBytes())
				.build()
				.parseClaimsJws(token) // Validates signature!
				.getBody();
	}

	private Key getSigningKeyBytes(){
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	private boolean isExprired(String token){
		return extractExpiration(token).before(new Date());
	}

	public boolean vaildateJwt(String token, UserDetails userDetails){
		return (extractUsername(token).equals(userDetails.getUsername()) && !isExprired(token));
	}

}
