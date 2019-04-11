package com.water.water_station.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/images/**","/js/**","/css/**", "/fonts/**","/vendor/**","/components/**").permitAll()
					.antMatchers("/profile/admin/**","/dashboard/**").hasAnyRole("ADMIN")
					.antMatchers("/profile/user/**").hasAnyRole("USER")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                        .loginPage("/login")
                        .permitAll()
                        .and()
                    .logout()
                        .permitAll()
                        .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        }
    
        // create two users, admin and user
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    
            auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER")
                
                .and()
                
                .withUser("admin")
                .password("{noop}password")
                .roles("ADMIN");
        }
}