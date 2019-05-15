package sprint.spring.exchange.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecureConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/exchange/ranking").permitAll()
                .antMatchers("/exchange/user/all/**").permitAll()
                .antMatchers("/exchange/user/admin/**").hasRole("ADMIN")
                .antMatchers("/exchange/user/user/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/exchange/book/all/**").permitAll()
                .antMatchers("/exchange/book/user/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/exchange/book/admin/**").hasRole("ADMIN")
                .antMatchers("/exchange/post/book/all/**").permitAll()
                .antMatchers("/exchange/post/book/user/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/exchange/post/book/admin/**").hasRole("ADMIN")
                .antMatchers("/exchange/receive/**").hasAnyRole("USER","ADMIN")
                .and()
                .httpBasic()
                .and().logout().and().formLogin();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery( " select login, password, is_active " +
                        " from z_user where login=? and is_active=true " ).
                authoritiesByUsernameQuery( " select u.login, " +
                        "ur.role as role " +
                        "from z_user_roles ur " +
                        "inner join z_user u on ur.user_id = u.id " +
                        "where u.login=? " );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}