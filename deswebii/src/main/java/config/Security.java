package config;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Security extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("GET", "/livro").permitAll().antMatchers("GET", "/livro*").permitAll()
		.anyRequest().authenticated().and().httpBasic();
	
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//log.info("Password encoded {}", passwordEncoder.encode("academy"));
		auth.inMemoryAuthentication()
		.withUser("Admin").password(passwordEncoder.encode("Admin")).roles("User","Admin").and()
		.withUser("user").password(passwordEncoder.encode("user")).roles("User");
	}
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    // ALTHOUGH THIS SEEMS LIKE USELESS CODE,
	    // IT'S REQUIRED TO PREVENT SPRING BOOT AUTO-CONFIGURATION
	    return super.authenticationManagerBean();
	}

	
}
