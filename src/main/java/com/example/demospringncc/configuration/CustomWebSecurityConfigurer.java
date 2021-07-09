package com.example.demospringncc.configuration;

import com.example.demospringncc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by noman.
 */
@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
         }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // Được quyền truy cập khi chưa login
        http.authorizeRequests().antMatchers("/login", "/signup","/shop/**","/images/**","/productImages/**","/","/home").permitAll();
        http.authorizeRequests().antMatchers("/admin").hasAnyAuthority("Admin").and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/error");
        http
                .authorizeRequests().antMatchers(
                "/register**",
                "/dist/**"
                , "/plugins/**"
                , "/bootstrap/**"
                , "/extra/**"
                , "/favicon.ico")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/shop")
//                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();

    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user@gmail.com").password(passwordEncoder().encode("password")).roles("USER")
//                .and()
//                .withUser("hongsonaaa@gmail.com").password(passwordEncoder().encode("123456")).roles("ADMIN");
//    }
    public void configure(WebSecurity web) throws Exception {
       // web.ignoring().antMatchers("/resources/static/**").anyRequest();
    }

}
