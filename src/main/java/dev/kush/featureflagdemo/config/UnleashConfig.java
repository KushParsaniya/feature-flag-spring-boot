package dev.kush.featureflagdemo.config;

import io.getunleash.UnleashContext;
import io.getunleash.UnleashContextProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.unleash.features.autoconfigure.UnleashProperties;

@Configuration
public class UnleashConfig {

    @Bean
    @ConditionalOnMissingBean
    UnleashContextProvider unleashContextProvider(UnleashProperties unleashProperties) {
        return () -> {
            UnleashContext.Builder builder = UnleashContext.builder();

            final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null) {
                System.out.println(authentication.getAuthorities().stream().findFirst().get().getAuthority());
                builder.userId(authentication.getAuthorities().stream().findFirst().get().getAuthority());
            }

            return builder
                    .appName(unleashProperties.getAppName())
                    .environment(unleashProperties.getEnvironment())
                    .build();
        };
    }
}
