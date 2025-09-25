package shop.calolink.entity;

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
    private BigDecimal kcal;

    @Column(nullable = false, precision = 6, scale = 1)
    private BigDecimal protein;

    @Column(nullable = false, precision = 6, scale = 1)
    private BigDecimal fat;

    @Column(nullable = false, precision = 6, scale = 1)
    private BigDecimal carb;

    @Column(nullable = false, precision = 6, scale = 1)
    private BigDecimal sugar;
}
