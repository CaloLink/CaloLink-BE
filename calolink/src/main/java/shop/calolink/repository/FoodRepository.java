package shop.calolink.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import shop.calolink.Category;
import shop.calolink.domain.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Page<Food> findByNameContaining(String name, Pageable pageable);

    Page<Food> findByCategory(Category category, Pageable pageable);

    Page<Food> findByNameContainingAndCategory(String name, Category category, Pageable pageable);
}
