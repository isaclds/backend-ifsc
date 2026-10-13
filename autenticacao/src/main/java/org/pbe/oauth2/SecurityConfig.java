package org.pbe.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("admin")
                .password("12345")
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("isac")
                .password("isac")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/login", "/api/erro").permitAll() // Únicas que não precisa de autenticação
                        .anyRequest().authenticated()) // resto precisa de login
                .formLogin(form -> form
                        .loginPage("/api/login")
                        .loginProcessingUrl("/api/login")
                        .defaultSuccessUrl("/api/receitas", true) // Para onde redireciona pós login
                        .failureUrl("/api/erro")) // URL para erro
                .logout(action -> action
                        .logoutUrl("/api/logout")
                        .logoutSuccessUrl("/api/login"));

        return http.build();
    }
}
