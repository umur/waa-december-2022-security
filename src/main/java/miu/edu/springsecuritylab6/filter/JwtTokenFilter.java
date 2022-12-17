package miu.edu.springsecuritylab6.filter;

import miu.edu.springsecuritylab6.constant.SecurityConstant;
import miu.edu.springsecuritylab6.utility.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    public JwtTokenFilter(JWTTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase(SecurityConstant.OPTIONS_HTTP_METHOD)) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if (authorizationHeader == null || !authorizationHeader.startsWith(SecurityConstant.TOKEN_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            } else {
                String token = authorizationHeader.substring(SecurityConstant.TOKEN_PREFIX.length());
                String username = jwtTokenProvider.getSubject(token);

                if (jwtTokenProvider.isTokenValid(username, token) && SecurityContextHolder.getContext().getAuthentication() == null) {
                    List<GrantedAuthority> grantedAuthorityList = jwtTokenProvider.getAuthoritiesFromToken(token);
                    Authentication authentication = jwtTokenProvider.getAuthentication(username, grantedAuthorityList, request);
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                } else {
                    SecurityContextHolder.clearContext();
                }
            }
            filterChain.doFilter(request, response);
        }
    }
}
