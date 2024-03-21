package com.awambeng.fullstackcrudapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorize -> authorize
//                        .antMatchers(
//                                "/registraton**",
//                                "/js/**",
//                                "/css/**",
//                                "/img/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/logout?logout")
//                        .permitAll()
//                );
//
//        return http.build();
//    }

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
