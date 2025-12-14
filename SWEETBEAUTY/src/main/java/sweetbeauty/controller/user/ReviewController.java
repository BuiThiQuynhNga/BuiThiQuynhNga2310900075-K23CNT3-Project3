package sweetbeauty.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sweetbeauty.entity.Review;
import sweetbeauty.entity.User;
import sweetbeauty.service.ReviewService;
import sweetbeauty.service.UserService;

import java.util.List;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/my-reviews")
    public String myReviews(Model model, HttpSession session) {

        // Lấy user đang đăng nhập
        User loggedUser = (User) session.getAttribute("loggedUser");

        // Nếu chưa login → chuyển sang login
        if (loggedUser == null) {
            return "redirect:/login";
        }

        // Lấy review theo User
        model.addAttribute("reviews", reviewService.findByUser(loggedUser));

        return "user/reviews";
    }
}