package com.gana_reciclando.security;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.gana_reciclando.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    String[] resources = new String[]{
            "components/*","assets/*","logic/*","pages/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/","/contact","/register","/about").permitAll()
                .antMatchers("/games").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }
    
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
    
   
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }

    @Autowired
    UserDetailsServiceImpl userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}