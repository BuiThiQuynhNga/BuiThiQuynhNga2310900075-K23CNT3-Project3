package sweetie.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sweetie.entity.Role;
import sweetie.entity.User;
import sweetie.repository.UserRepository;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initAdmin() {
        // Kiểm tra nếu admin3 chưa có thì tạo mới
        if (userRepository.findByUsername("admin3") == null) {
            User admin = new User();
            admin.setUsername("admin3");
            admin.setPassword(passwordEncoder.encode("3")); // encode mật khẩu
            admin.setFullName("Admin Three");
            admin.setEmail("admin3@gmail.com");
            admin.setPhone("0123456789");
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);
            System.out.println(">>> Admin3 account created successfully!");
        }
    }
}
