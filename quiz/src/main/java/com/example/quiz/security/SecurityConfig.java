package com.example.quiz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
	    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

	    jdbcUserDetailsManager.setUsersByUsernameQuery(
	            "SELECT username, password, enabled FROM user WHERE username=?");

	    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
	            "SELECT username, role FROM user WHERE username=?");

	    return jdbcUserDetailsManager;
	}


    // Password encoder (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                          .anyRequest().permitAll()
//                        .request	Matchers(HttpMethod.POST, "/api/quizzes/**").hasAuthority("ROLE_ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/api/quizzes/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/api/quizzes/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/quizzes/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
//                        .anyRequest().authenticated()
        );

        http.httpBasic();
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
