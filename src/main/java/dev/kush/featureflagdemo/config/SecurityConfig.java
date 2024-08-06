package dev.kush.featureflagdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService userDetails() {

        UserDetails u1 = User.withUsername("kush")
                .password("1234")
                .authorities("beta")
                .build();

        UserDetails u2 = User.withUsername("abcd")
                .password("1234")
                .authorities("stable")
                .build();

        return new InMemoryUserDetailsManager(u1,u2);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
