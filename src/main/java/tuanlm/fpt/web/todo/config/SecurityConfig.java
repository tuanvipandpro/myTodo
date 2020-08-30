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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import tuanlm.fpt.web.todo.service.UserDetailsServiceImpl;

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
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
//		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//		db.setDataSource(dataSource);
//		return db;
		return new InMemoryTokenRepositoryImpl();
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/", "/login", "logout").permitAll();
		
		http.authorizeRequests().antMatchers("/home").access("hasRole('MEMBER')");
		
		http.authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')");
		
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
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
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logoutSuccessful");

        // Cấu hình Remember Me.
//        http.authorizeRequests().and() //
//                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
//                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
	}
}
