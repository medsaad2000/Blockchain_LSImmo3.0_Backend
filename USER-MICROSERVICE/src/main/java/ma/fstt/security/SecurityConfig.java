package ma.fstt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;


    //----------- Configuration of spring security ------------
    //une fois qu'un user tente de se connecte tu n'as qu'a appeler cette interface,qu'elle appelle ensuite methode loadbyusername;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll();
        http.authorizeRequests().antMatchers("/appUsers/**", "/appRoles/**").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        //--------- filters -------------
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

//		@Override
//		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
////			auth.inMemoryAuthentication().withUser("admin").password(bcpe.encode("admin")).roles("ADMIN", "USER");
////			auth.inMemoryAuthentication().withUser("user1").password(bcpe.encode("user1")).roles("USER");						
//			auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN", "USER");
//			auth.inMemoryAuthentication().withUser("user1").password("{noop}user1").roles("USER");						
//		
//		}


//		@Override
//		protected void configure(HttpSecurity http) throws Exception{
////			super.configure(http);
//			http.csrf().disable();
////			http.formLogin();
//			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//			http.authorizeRequests().antMatchers("/posts/**").hasAuthority("ADMIN");
//			http.authorizeRequests().antMatchers("/announcements/**").hasAuthority("USER");
//			//--------- other routes need authentication ---------
//			http.authorizeRequests().anyRequest().authenticated();
////			http.addFilter((new JWTAuthorizationFilter(authenticationManager()))
//			http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
////			http.authorizeRequests().anyRequest().permitAll();
//		}


//		// Expose the UserDetailsService as a Bean
//		 @Bean
//		 @Override
//		 public UserDetailsService userDetailsServiceBean() throws Exception {
//		        return super.userDetailsServiceBean();
//		 }

//		@Bean
//		BCryptPasswordEncoder getBCPE() {
//			return new BCryptPasswordEncoder();
//		}
}
