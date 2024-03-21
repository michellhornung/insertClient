package com.hornung.crud.clients.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * Classe de configuração para definir configurações de segurança na aplicação.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Define a cadeia de filtros de segurança para requisições HTTP.
     *
     * @param http Objeto HttpSecurity para configurar as configurações de segurança
     * @return Objeto SecurityFilterChain representando a cadeia de filtros de segurança
     * @throws Exception se ocorrer um erro durante a configuração
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.cors(cors -> cors.configurationSource(corsConfigurationSource()));

        http.authorizeHttpRequests(authorization -> {
            authorization.requestMatchers(HttpMethod.POST, "/v1/client").permitAll();
            authorization.requestMatchers(HttpMethod.DELETE, "/v1/client/{id}").permitAll();
            authorization.requestMatchers(HttpMethod.PUT, "/v1/client").permitAll();
            authorization.requestMatchers(HttpMethod.GET, "/v1/client").permitAll();
        });

        return http.build();
    }

    /**
     * Customiza as configurações de segurança da web.
     *
     * @return Objeto WebSecurityCustomizer para customizar a segurança da web
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }

    /**
     * Fornece um bean AuthenticationManager.
     *
     * @param configuration Objeto AuthenticationConfiguration para obter o gerenciador de autenticação
     * @return Objeto AuthenticationManager para gerenciar a autenticação
     * @throws Exception se ocorrer um erro durante a recuperação do gerenciador de autenticação
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /**
     * Configura as configurações CORS (Compartilhamento de Recursos de Origem Cruzada).
     *
     * @return Objeto CorsConfigurationSource representando a fonte de configuração CORS
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();

        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedOrigins(List.of("*"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
