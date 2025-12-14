package sweetbeauty.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sweetbeauty.entity.Role;
import sweetbeauty.entity.User;
import sweetbeauty.entity.Cart;
import sweetbeauty.repository.UserRepository;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initAdmin() {
        if (userRepository.findByUsername("admin3") == null) {

            User admin = new User();
            admin.setUsername("admin3");
            admin.setPassword(passwordEncoder.encode("admin123")); // password an toàn hơn
            admin.setFullName("Admin Three");
            admin.setEmail("admin3@gmail.com");
            admin.setPhone("0123456789");
            admin.setRole(Role.ADMIN);

            // ⭐ Thêm Cart vào admin để tránh lỗi null
            Cart cart = new Cart();
            admin.setCart(cart);

            userRepository.save(admin);
            System.out.println(">>> Admin3 account created successfully!");
        }
    }
}
