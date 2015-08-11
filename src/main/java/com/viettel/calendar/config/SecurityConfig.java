/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */
package com.viettel.calendar.config;

import com.zaxxer.hikari.HikariDataSource;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.RegexRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

/**
 *
 * @author hieptran
 */
@Configuration
@ComponentScan("com.viettel.calendar.auth")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;
    
    @Autowired
    HikariDataSource dataSource;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/admin**","/admin/**").access("hasRole('ROLE_USER')").antMatchers("/home**","/home/**")
            .access("hasRole('ROLE_USER')")
            .and().formLogin()
                .loginPage("/login").failureUrl("/login?error").successHandler(savedRequestAwareAuthenticationSuccessHandler())
                .loginProcessingUrl("/auth/login_check")
                .usernameParameter("username")
                .passwordParameter("password")
            .and().logout()
                .logoutUrl("/j_spring_security_logout")
                .logoutSuccessUrl("/login?logout")
            .and().csrf()
            .and().exceptionHandling().accessDeniedPage("/403")
            .and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(946080000);
        
        http.csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
            private final Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
            private final RegexRequestMatcher apiMatcher = new RegexRequestMatcher("/api*/.*", null);

            @Override
            public boolean matches(HttpServletRequest request) {
                // Không phải post thì đồng ý liền
                if(allowedMethods.matcher(request.getMethod()).matches()){
                    return false;
                }

                return !apiMatcher.matches(request);
            }
        });
    }
        
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new CustomPasswordEncoder();
        return encoder;
    }
        
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler auth = new SavedRequestAwareAuthenticationSuccessHandler();
        auth.setTargetUrlParameter("targetUrl");
        return auth;
    }
}
