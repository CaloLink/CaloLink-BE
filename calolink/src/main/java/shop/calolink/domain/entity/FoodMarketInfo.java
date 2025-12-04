package shop.calolink.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "FoodMarketInfo")
public class FoodMarketInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String link; // 구매 링크

    private int price;   // 현재 가격 (나중에 업데이트 가능)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    public void updatePrice(int price) {
        this.price = price;
    }
}
