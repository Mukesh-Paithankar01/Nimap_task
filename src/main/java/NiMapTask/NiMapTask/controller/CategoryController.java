package NiMapTask.NiMapTask.controller;

import NiMapTask.NiMapTask.dto.CategoriesDto;
import NiMapTask.NiMapTask.entity.Category;
import NiMapTask.NiMapTask.service.CategoriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoriesServices categoriesServices;

    @PostMapping
    public Category createCategory(@RequestBody CategoriesDto category) {
        // Logic to save the category would go here
        // For now, we will just return the category object
        return categoriesServices.createCategory(category);
    }
    @GetMapping
    public List<Category> getAllCategories(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){

        return categoriesServices.getAllCategories(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriesServices.getCategoryById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,
                                                   @RequestBody CategoriesDto category) {
        return ResponseEntity.ok(categoriesServices.updateCategory(id, category));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoriesServices.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
