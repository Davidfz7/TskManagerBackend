
package TskManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class ProjectConfig implements WebMvcConfigurer {
    
    @Bean
    
    public InMemoryUserDetailsManager userDetailsManager(){
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        
        UserDetails userOne = users
                             .username("testUserOne")
                             .password("passwordOne")
                             .roles("USER")
                             .build();
                
        
    }
    
}
