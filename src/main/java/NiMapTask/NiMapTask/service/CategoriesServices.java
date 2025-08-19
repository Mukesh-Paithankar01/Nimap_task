package NiMapTask.NiMapTask.service;

import NiMapTask.NiMapTask.dto.CategoriesDto;
import NiMapTask.NiMapTask.entity.Category;

import java.util.List;

public interface CategoriesServices {
    Category createCategory(CategoriesDto category);

    List<Category> getAllCategories(int page, int size);

    Category getCategoryById(Long id);
    Category updateCategory(Long id, CategoriesDto category);
    void deleteCategory(Long id);
}
