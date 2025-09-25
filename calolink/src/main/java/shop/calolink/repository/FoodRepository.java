package shop.calolink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.calolink.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
