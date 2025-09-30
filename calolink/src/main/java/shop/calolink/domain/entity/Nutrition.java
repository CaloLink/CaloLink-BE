package shop.calolink.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nutrition")
public class Nutrition {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @Column(nullable = false, precision = 6, scale = 1)
    private double kcal;

    @Column(nullable = false, precision = 6, scale = 1)
    private double protein;

    @Column(nullable = false, precision = 6, scale = 1)
    private double fat;

    @Column(nullable = false, precision = 6, scale = 1)
    private double carb;

    @Column(nullable = false, precision = 6, scale = 1)
    private double sugar;

    @Column(nullable = false, precision = 6, scale = 1)
    private double cholesterol;

    @Column(nullable = false, precision = 6, scale = 1)
    private double saturatedFat;

    @Column(nullable = false, precision = 6, scale = 1)
    private double transFat;
}
