/**
 * 
 */
package tuanlm.fpt.web.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @author Tuan
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private DataSource dataSource;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
//		Remeber Me With DB
//		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//		db.setDataSource(dataSource);
//		return db;
//		Remeber Me With Server Mememory		
		return new InMemoryTokenRepositoryImpl();
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		// Page For All
		http.authorizeRequests().antMatchers("/", "/login", "logout").permitAll();
		// Login with ROLE_MEMBER
		http.authorizeRequests().antMatchers("/home").access("hasRole('ROLE_MEMBER')");
		http.authorizeRequests().antMatchers("/account/**").access("hasRole('ROLE_MEMBER')");
		http.authorizeRequests().antMatchers("/task-service/**").access("hasRole('ROLE_MEMBER')");
		// Login with ROLE_ADMIN
		http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
		// Config Forbidden
		http.authorizeRequests()
				.and()
				.exceptionHandling().accessDeniedPage("/403");
		// Config LoginForm
        http.authorizeRequests()
        		.and()
        		.formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/")//
                .defaultSuccessUrl("/home")
                .failureUrl("/welcome?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
        // Config Logout
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
        // Config Remember me
        http.authorizeRequests()
        	.and()
            .rememberMe().tokenRepository(this.persistentTokenRepository())
            .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
	}
}
