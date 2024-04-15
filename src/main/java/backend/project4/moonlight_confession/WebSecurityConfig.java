package backend.project4.moonlight_confession;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import backend.project4.moonlight_confession.web.UserDetailServiceImpl;
import backend.project4.moonlight_confession.web.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	@Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
	private UserDetailServiceImpl userDetailsService;

    // with lambda
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests(authorize -> authorize
		.requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
		.requestMatchers("/signup", "/saveuser").permitAll()
		.anyRequest().authenticated()
	)
	.formLogin(formLogin -> formLogin
		.loginPage("/login")
		.defaultSuccessUrl("/recipientlist", true)
		.permitAll()
	)
	.logout(logout -> logout
		.permitAll()
	)
	.oauth2Login(oauth2Login -> oauth2Login
		.loginPage("/login")  // Use the same login page for OAuth2
		.defaultSuccessUrl("/recipientlist", true)
		.userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
			.userService(customOAuth2UserService)
		)
	);
return http.build();
	}

	  @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
