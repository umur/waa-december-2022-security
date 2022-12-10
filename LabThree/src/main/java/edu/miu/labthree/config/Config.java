package edu.miu.labthree.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class Config extends
        WebSecurityConfigurerAdapter {

    @Override public void configure(HttpSecurity security) throws Exception {
        // Here, we get to allow who is able to go where?

        security
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/products/**")
                .permitAll()
                .antMatchers("/api/v1/users")
                .hasAuthority("ADMIN")
                .antMatchers("/api/v1/posts")
                .hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        security.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
