package NiMapTask.NiMapTask.repo;

import NiMapTask.NiMapTask.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepo extends JpaRepository<Category, Long>{
}
