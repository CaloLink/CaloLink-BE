package shop.calolink.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "nutrition")
public class Nutrition {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @Column(nullable = false, precision = 6, scale = 1)
    private Double kcal;

    @Column(nullable = false, precision = 6, scale = 1)
    private Double protein;

    @Column(nullable = false, precision = 6, scale = 1)
    private Double fat;

    @Column(nullable = false, precision = 6, scale = 1)
    private Double carb;

    @Column(nullable = false, precision = 6, scale = 1)
    private Double sugar;

    @Column(nullable = false, precision = 6, scale = 1)
    private Double cholesterol;

    @Column(nullable = false, precision = 6, scale = 1)
    private Double saturatedFat;

    @Column(nullable = false, precision = 6, scale = 1)
    private Double transFat;
}
