package NiMapTask.NiMapTask.service;

import NiMapTask.NiMapTask.dto.CategoriesDto;
import NiMapTask.NiMapTask.entity.Category;
import NiMapTask.NiMapTask.repo.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServicesImp implements CategoriesServices{
    @Autowired
    CategoriesRepo categoriesRepo;
    @Override
    public Category createCategory(CategoriesDto category) {

        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());
        if (newCategory.getName() != null && !newCategory.getName().isEmpty()) {
            return categoriesRepo.save(newCategory);
        }

        return null;
    }

    @Override
    public List<Category> getAllCategories(int page, int size) {

        Pageable pageable= PageRequest.of(page, size);
        Page<Category> categoriesPage = categoriesRepo.findAll(pageable);
        List<Category> category = categoriesPage.getContent();

        return category;

    }

    @Override
    public Category getCategoryById(Long id) {
        return categoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    }
    @Override
    public Category updateCategory(Long id, CategoriesDto categoryDto) {
        Category existing = categoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        existing.setName(categoryDto.getName());
        existing.setDescription(categoryDto.getDescription());
        return categoriesRepo.save(existing);
    }
    @Override
    public void deleteCategory(Long id) {
        Category existing = categoriesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        categoriesRepo.delete(existing);
    }
}
