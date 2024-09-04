package com.phbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity()
public class SecurityConfig {
	
	@Bean
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	}

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		
			.authorizeHttpRequests(authorizeRequests -> authorizeRequests
				.requestMatchers("/WEB-INF/views/**","/css/**","/images/**","/javascript/**").permitAll()
				
            	.anyRequest().authenticated())
		
			.formLogin(form -> form
				.loginPage("/login/")
				.loginProcessingUrl("/login/processLogin")
				.defaultSuccessUrl("/home/", false)
				.usernameParameter("acctNum")
            	.passwordParameter("password")
            	.permitAll());
		
		return http.build();
	}
	
	 @Bean
		public InMemoryUserDetailsManager setUpUser() {
			UserDetails user1 = 
					User
						.withUsername("131313131313")
						.password("$2y$10$evkW/4cs9EQXmwmw8BQQnuzp96IRYzOrjpKUJ2Mit0T990oIH76s.")	//password
						.roles("admin", "user")
						.build();
			
			UserDetails user2 = 
					User
						.withUsername("121212121212")
						.password("$2y$10$S.JGVJwEsNT8MaIoRQNbVe0wn4z/jNe1XMVQfsxYWO/Ilidrrh5pa")		//pass123
						.roles("user")
						.build();
			return new InMemoryUserDetailsManager(user1, user2);
		}
}
