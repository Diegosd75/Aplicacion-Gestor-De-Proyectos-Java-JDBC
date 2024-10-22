package com.company.ProyectosTareas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig {

    private final DataSource dataSource;

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        // Consulta para obtener el usuario y la contraseña
        manager.setUsersByUsernameQuery("SELECT username, CONCAT('{noop}', password),1 FROM usuarios WHERE username = ?");
        // Consulta para obtener el rol del usuario
        manager.setAuthoritiesByUsernameQuery("SELECT username, CONCAT('ROLE_', role) FROM usuarios WHERE username = ?");
        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()) // habilita el formulario de login predeterminado
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
