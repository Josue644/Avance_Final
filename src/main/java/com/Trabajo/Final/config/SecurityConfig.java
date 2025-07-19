package com.Trabajo.Final.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Trabajo.Final.security.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
            .authorizeHttpRequests(auth -> auth    
                .requestMatchers(
                    "/", 
                    "/index", 
                    "/beneficios",
                    "/comunidad", 
                    "/cursos", 
                    "/elementos-clave",
                    "/historia",
                    "/confirmacion",
                    "/nosotros",
                    "/sedes",
                    "/preguntas",
                    "/matricula2025",
                    "/formulario", 
                    "/fragments.html", 
                    "/images/**",
                    "/css/**", 
                    "/js/**").permitAll()
                .requestMatchers("/iniciar-sesion").permitAll()
                .requestMatchers("/dashboard/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/iniciar-sesion")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            )
            .userDetailsService(customUserDetailsService);
    
        return http.build(); 
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
