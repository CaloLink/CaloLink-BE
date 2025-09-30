package shop.calolink.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import shop.calolink.Category;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "food")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nullable: @NotNull이랑 비슷하다고 지금은 생각하고
    // 차이점 궁금하면 따로 알아보기.
    @Column(length = 20, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Category category;

    @Column(length = 20, nullable = false)
    private String manufacturer;

    @Column(length = 255)
    private String imageUrl;

    @OneToMany (
            mappedBy = "food",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Nutrition> nutritions = new ArrayList<>();
}



