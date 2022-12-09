package miu.edu.springdata.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtHelper {
    @Autowired
    private Environment env;
    private final String secret;//= env.getProperty("jwt.secret");// "suntalikomanmabasnekohola";// "c3VudGFsaWtvbWFubWFiYXNuZWtvaG9sYQ==";//
    private final long expiration;// = Long.parseLong(env.getProperty("jwt.expiration")); //5*60*60*60;

    public JwtHelper(Environment env){
        this.env = env;
        secret = this.env.getProperty("jwt.secret");// "suntalikomanmabasnekohola";// "c3VudGFsaWtvbWFubWFiYXNuZWtvaG9sYQ==";//
        expiration = Long.parseLong(this.env.getProperty("jwt.expiration")); //5*60*60*60;
    }

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

//    public String generateRefreshToken

    public String getSubject(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        }catch (SignatureException e){
            System.out.println(e.getMessage());
        }catch (MalformedJwtException e){
            System.out.println(e.getMessage());
        }catch (ExpiredJwtException e){
            System.out.println(e.getMessage());
        }catch (UnsupportedJwtException e){
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String getUsernameFromToken(String token){
        String result = null;
        if(validateToken(token)){
            result = getSubject(token);
        }
        return  result;
    }
}
