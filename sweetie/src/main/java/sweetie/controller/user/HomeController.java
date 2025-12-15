package sweetie.controller.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sweetie.entity.Product;
import sweetie.entity.User;
import sweetie.repository.ProductRepository;

import java.util.List;

@Controller
public class HomeController {

    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal User user) {
        List<Product> featuredProducts = productRepository.findByFeaturedTrue();
        model.addAttribute("featuredProducts", featuredProducts);
        model.addAttribute("user", user); // để hiển thị tên user nếu đã login
        return "user/home";
    }
}
