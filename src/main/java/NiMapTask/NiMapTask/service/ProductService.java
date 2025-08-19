package NiMapTask.NiMapTask.service;

import NiMapTask.NiMapTask.dto.ProductDto;
import NiMapTask.NiMapTask.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDto product);
    List<Product> getAllProducts(int page, int size);


    Product getProductById(Long id);

    Product updateProduct(Long id, ProductDto product);

    void deleteProduct(Long id);


}
