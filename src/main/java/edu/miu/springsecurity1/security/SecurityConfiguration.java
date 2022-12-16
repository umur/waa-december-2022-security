package edu.miu.springsecurity1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import lombok.RequiredArgsConstructor;

@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtFilter jwtFilter;

    private final KeycloakLogoutHandler keycloakLogoutHandler;

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/products*", "/users*")
                .hasRole("USER")
                .anyRequest()
                .permitAll();
        http.oauth2Login()
                .and()
                .logout()
                .addLogoutHandler(keycloakLogoutHandler)
                .logoutSuccessUrl("/");
        return http.build();
    }

    // @Bean
    // public RoleHierarchy roleHierarchy() {
    // RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
    // String hierarchy = "ROLE_ADMIN > ROLE_GOLD > ROLE_BRONZE > ROLE_SILVER";
    // roleHierarchy.setHierarchy(hierarchy);
    // return roleHierarchy;
    // }
    //
    // @Bean
    // public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
    // DefaultWebSecurityExpressionHandler expressionHandler = new
    // DefaultWebSecurityExpressionHandler();
    // expressionHandler.setRoleHierarchy(roleHierarchy());
    // return expressionHandler;
    // }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            UserDetailsService userDetailService)
            throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http
    // .cors()
    // .and()
    // .csrf().disable()
    // .authorizeRequests()
    // .antMatchers("/uaa", "/uaa/signup").permitAll()
    // // .antMatchers(HttpMethod.POST,"/api/v1/users").hasAuthority("ADMIN")
    // // .antMatchers(HttpMethod.GET,"/products").hasAuthority("GOLD")
    // .anyRequest()
    // .authenticated()
    // .and()
    // .sessionManagement()
    // .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    // return http.build();
    // }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // private final UserDetailsService awesomeUserDetailsService;
    // private final JwtFilter jwtFilter;
    //
    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.userDetailsService(awesomeUserDetailsService);
    // }
    //
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //
    // http
    // .csrf().disable()
    // .authorizeRequests()
    // .antMatchers("/uaa").permitAll()
    // .antMatchers("/products").hasAuthority("CLIENT")
    // .anyRequest()
    // .authenticated()
    // .and()
    // .sessionManagement()
    // .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    //
    // http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    //
    // }
    //
    // @Bean
    // @Override
    // public AuthenticationManager authenticationManagerBean() throws Exception {
    // return super.authenticationManagerBean();
    // }
    //
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder();
    // }
}
