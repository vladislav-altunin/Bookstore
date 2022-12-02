package com.altunin.Bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.altunin.Bookstore.Service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Inject authentication and authorization
	@Autowired
	private UserDetailServiceImpl userDetailsServiceImpl;

	// Enable h2-console (otherwise error 403)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**", "/resources/**", "/static/**","/webjars/**");
	}

	// Secure URLs (all URLs are secured by default)
	// Define login page
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login", "/css/**",
                "/js/**",
                "/img/**",
                "/**/favicon.ico",
                "/webjars/**",
                "/signup").permitAll()
				.antMatchers("/delete/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin().loginPage("/login")
				.defaultSuccessUrl("/booklist", true)
				.permitAll();
	}

	// In-memory users
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user1 = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//		
//		UserDetails user2 = User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("password")
//				.roles("ADMIN")
//				.build();
//		
//		List<UserDetails> users = new ArrayList<UserDetails>();
//		users.add(user1);
//		users.add(user2);
//		
//		return new InMemoryUserDetailsManager(users);
//	}

	// Users from the database
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}

}
