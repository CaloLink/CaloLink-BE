package shop.calolink.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nutrition")
public class Nutrition {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    양방향 매핑 -> 단방향 매핑
//    @OneToOne(fetch = FetchType.LAZY, optional = false)   // ManyToOne -> OneToOne
//    @JoinColumn(name = "food_id", nullable = false, unique = true)   // unique 추가. unique로 1:1 보장
//    private Food food;

    @Column(nullable = false)
    private Integer kcal;

    @Column(nullable = false)
    private Double protein;

    @Column(nullable = false)
    private Double fat;

    @Column(nullable = false)
    private Double carb;

    @Column(nullable = false)
    private Double sugar;

    @Column(nullable = false)
    private Double cholesterol;

    @Column(nullable = false)
    private Double saturatedFat;

    @Column(nullable = false)
    private Double transFat;

    @Column(nullable = false)
    private Integer sodium;
}
