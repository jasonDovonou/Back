package util;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class Tokens {

	private static SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	// Sample method to construct a JWT
	public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject)
				.setIssuer(issuer).signWith(key);

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	// Sample method to validate and read the JWT
	public static Claims parseJWT(String jwt) {
		// This line will throw an exception if it is not a signed JWS (as
		// expected)
		return Jwts.parser().setSigningKey(key.getEncoded()).parseClaimsJws(jwt).getBody();
	}

}
