package com.prade.JPA.SpringWithJPA.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

 /*   @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }*/
    
    @Autowired
    private BasicAuth basicAuth;
    
    @Value("${spring.security.user.name}")
	private  String userName;
    
    @Value("${spring.security.user.password}")
	private  String password;
    
    @Value("${spring.security.user.roles}")
	private  String role;


  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
       // http.authorizeRequests()
       // http.authorizeRequests().antMatchers("/", "/api/**").permitAll()
        http.authorizeRequests().antMatchers("/", "/v1/*").authenticated()
        .anyRequest().authenticated();
        http.httpBasic().authenticationEntryPoint(basicAuth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/health");
        web.ignoring().antMatchers("/prometheus");
        web.ignoring().antMatchers("/v1/");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.inMemoryAuthentication().withUser(userName).password("{noop}"+password).roles(role);
         
    }

}
