package sweetbeauty.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sweetbeauty.repository.OrderRepository;
import sweetbeauty.repository.UserRepository;
import sweetbeauty.repository.ReviewRepository;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    // Trang chính dashboard
    @GetMapping({"", "/", "/index"})
    public String adminHome(Model model) {

        // ===== 1️⃣ Thống kê tổng quan =====
        Double totalRevenue = orderRepository.getTotalRevenue();
        if (totalRevenue == null) totalRevenue = 0.0; // Nếu chưa có đơn hàng

        long userCount = userRepository.count();        // Tổng số người dùng
        long purchaseCount = orderRepository.count();  // Tổng số đơn hàng

        Double averageRating = reviewRepository.getAverageRating();
        if (averageRating == null) averageRating = 0.0;

        model.addAttribute("totalRevenue", totalRevenue);
        model.addAttribute("userCount", userCount);
        model.addAttribute("purchaseCount", purchaseCount);
        model.addAttribute("averageRating", String.format("%.1f/5", averageRating));

        // ===== 2️⃣ Biểu đồ doanh thu theo tháng =====
        List<String> months = new ArrayList<>();
        List<Double> revenues = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            // Lấy tên tháng viết tắt (Jan, Feb, …)
            months.add(Month.of(i).getDisplayName(TextStyle.SHORT, Locale.ENGLISH));

            // Lấy doanh thu từng tháng
            Double revenue = orderRepository.getRevenueByMonth(i);
            revenues.add(revenue == null ? 0.0 : revenue);
        }

        model.addAttribute("months", months);
        model.addAttribute("revenues", revenues);

        return "admin/index"; // View Thymeleaf
    }
}
