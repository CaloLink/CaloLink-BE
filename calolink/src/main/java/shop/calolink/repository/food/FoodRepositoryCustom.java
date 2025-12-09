package shop.calolink.repository.food;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.calolink.Category;
import shop.calolink.domain.entity.Food;

public interface FoodRepositoryCustom {

    // 검색 API
    Page<Food> searchFood(Predicate predicate, Pageable pageable);

    Page<Food> searchFoods(String name, Category category, Pageable pageable);
}
