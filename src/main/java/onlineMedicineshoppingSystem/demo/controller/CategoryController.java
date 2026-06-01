package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Category;
import onlineMedicineshoppingSystem.demo.server.CategoryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Category")
public class CategoryController {

    @Autowired
    private CategoryServer categoryServer;

    @GetMapping("")
    public List<Category> getAllCategory() {
        return categoryServer.getAllCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryByID(@PathVariable("id") Long id) {
        return categoryServer.findCategoryById(id);
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryServer.saveCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryServer.deleteCategory(id);
    }
}
