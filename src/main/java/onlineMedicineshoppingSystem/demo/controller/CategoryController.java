package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Category;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CategoryController {

    @GetMapping("")
    public void getAllCategory() {
        return;
    }

    @GetMapping("/{id}")
    public void getCategoryByID(@PathVariable("id") Long id) {
        return;
    }

    @PostMapping("/save")
    public void saveCategory(@RequestBody Category category) {
        return;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        return;
    }
}
