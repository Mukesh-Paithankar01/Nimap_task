package NiMapTask.NiMapTask.service;

import NiMapTask.NiMapTask.dto.ProductDto;
import NiMapTask.NiMapTask.entity.Category;
import NiMapTask.NiMapTask.entity.Product;
import NiMapTask.NiMapTask.repo.CategoriesRepo;
import NiMapTask.NiMapTask.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoriesRepo categoriesRepo;

    @Override
    public Product createProduct(ProductDto productDto) {
        Category category = categoriesRepo.findById(productDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id " + productDto.getCategoryId()));

        Product newProduct = new Product();
        newProduct.setName(productDto.getName());
        newProduct.setDescription(productDto.getDescription());
        newProduct.setPrice(productDto.getPrice());
        newProduct.setCategory(category);

        return productRepo.save(newProduct);
    }

    @Override
    public List<Product> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productsPage = productRepo.findAll(pageable);
        return productsPage.getContent();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    @Override
    public Product updateProduct(Long id, ProductDto productDto) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));

        existing.setName(productDto.getName());
        existing.setDescription(productDto.getDescription());
        existing.setPrice(productDto.getPrice());
        return productRepo.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        productRepo.delete(existing);
    }

}
