package onlineMedicineshoppingSystem.demo.controller;

import onlineMedicineshoppingSystem.demo.entity.Category;
import onlineMedicineshoppingSystem.demo.server.CategoryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Category")
public class CategoryController {

    @Autowired
    private CategoryServer categoryServer;

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> list = categoryServer.getAllCategory();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryByID(@PathVariable("id") Long id) {
        Optional<Category> category = categoryServer.findCategoryById(id);
        if(category.isPresent()) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category saveCategory = categoryServer.saveCategory(category);
        return ResponseEntity.ok(saveCategory);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long id) {
        categoryServer.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
