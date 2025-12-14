package sweetbeauty.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // tạm tắt CSRF để test
                .authorizeHttpRequests(auth -> auth
                        // Các trang public
                        .requestMatchers("/", "/products/**", "/categories/**", "/login", "/register", "/css/**", "/js/**", "/images/**").permitAll()

                        // Trang admin
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // Trang user
                        .requestMatchers("/user/**").hasRole("USER")

                        // Các request khác cần login
                        .anyRequest().authenticated()
                )
                .userDetailsService(customUserDetailsService)
                .formLogin(login -> login
                        .loginPage("/login") // trang login custom
                        .successHandler((req, res, auth) -> {
                            String role = auth.getAuthorities().iterator().next().getAuthority();
                            if ("ROLE_ADMIN".equals(role)) {
                                res.sendRedirect("/admin/index");
                            } else if ("ROLE_USER".equals(role)) {
                                res.sendRedirect("/user/index");
                            } else {
                                res.sendRedirect("/"); // fallback
                            }
                        })
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
