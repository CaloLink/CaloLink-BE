package shop.calolink.repository.nutrition;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.calolink.domain.entity.Nutrition;

public interface NutritionRepository extends JpaRepository<Nutrition, Long> {

}
