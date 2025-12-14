package sweetbeauty.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sweetbeauty.entity.Category;
import sweetbeauty.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/categories")
@PreAuthorize("hasRole('ADMIN')") // Chỉ admin mới truy cập được
public class AdminCategoryController {

    private final CategoryRepository categoryRepository;

    public AdminCategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Danh sách category
    @GetMapping
    public String listCategories(Model model, @RequestParam(required = false) String message) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("message", message);
        return "admin/categories/list";
    }

    // Form thêm mới
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/categories/form";
    }

    // Form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        if (categoryOpt.isPresent()) {
            model.addAttribute("category", categoryOpt.get());
            return "admin/categories/form";
        } else {
            return "redirect:/admin/categories?message=CategoryNotFound";
        }
    }

    // Lưu category (add + edit)
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/categories?message=SavedSuccessfully";
    }

    // Xóa category
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "redirect:/admin/categories?message=DeletedSuccessfully";
        }
        return "redirect:/admin/categories?message=CategoryNotFound";
    }
}
