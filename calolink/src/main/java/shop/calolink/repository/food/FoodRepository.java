package shop.calolink.repository.food;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.calolink.domain.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>, FoodRepositoryCustom {

}
