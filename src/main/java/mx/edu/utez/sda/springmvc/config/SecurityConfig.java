package mx.edu.utez.sda.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password(
                        passwordEncoder().encode("user123")
                )
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(
                        passwordEncoder().encode("admin123")
                )
                .roles("ADMIN")
                .build();

        UserDetails recepcion = User.withUsername("recepcion")
                .password(
                        passwordEncoder().encode("recepcion123")
                )
                .roles("RECE")
                .build();

        UserDetails ninios = User.withUsername("ninios")
                .password(
                        passwordEncoder().encode("ninios123")
                )
                .roles("NINIO")
                .build();

        UserDetails adulto = User.withUsername("adulto")
                .password(
                        passwordEncoder().encode("adulto123")
                )
                .roles("ADUL")
                .build();

        return new InMemoryUserDetailsManager(user, admin, recepcion, ninios, adulto);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((request) -> {
           request.requestMatchers("/", "/index").permitAll();
           request.anyRequest().authenticated();
        });

        httpSecurity.formLogin((login) -> {
            login.loginPage("/login").permitAll();
        });

        httpSecurity.logout((logout) -> {
           logout.permitAll();
        });

        return httpSecurity.build();

    }
}
