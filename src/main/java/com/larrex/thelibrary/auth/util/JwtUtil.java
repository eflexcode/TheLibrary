package com.larrex.thelibrary.auth.util;

import com.larrex.thelibrary.Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {


    private final String keyword = "Our ancestors understood reality and existence in a very profound way, we exchanged all these for the western religion while the westerners themselves are continuously and gradually looking eastwards and anywhere else for real spiritual experience, it's almost comical";

    public String generateJWT(UserDetails userDetails) {

        Map<String, Object> map = new HashMap<>();

        return Jwts.builder()
                .addClaims(map)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Util.JWT_TWO_MONTHS_EXP_TIME))
                .signWith(signKey(keyword), SignatureAlgorithm.HS512)
                .compact();
    }

    private Key signKey(String secretPhrase){
        byte[] bytes = secretPhrase.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(bytes);
    }

    private <T> T getClaimsFromToken(String token, Function<Claims,T> function){

        final Claims claims = Jwts.parserBuilder().
                setSigningKey(signKey(keyword)).build().parseClaimsJws(token).getBody();

        return function.apply(claims);
    }

    public String getUsernameFromToken(String token){
        return getClaimsFromToken(token,Claims::getSubject);
    }

    public Date getExpDateFromToken(String token){
        return getClaimsFromToken(token,Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        final Date exp_date = getExpDateFromToken(token);
        return exp_date.before(new Date());
    }

    public boolean validateToken(String token,String sentUsername){

        String tokenUsername = getUsernameFromToken(token);
        return tokenUsername.equals(sentUsername) && !isTokenExpired(token);

    }

}
