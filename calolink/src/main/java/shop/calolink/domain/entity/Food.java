package shop.calolink.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import shop.calolink.Category;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "food")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nullable: @NotNull이랑 비슷하다고 지금은 생각하고
    // 차이점 궁금하면 따로 알아보기.
    @Column(length = 50, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Category category;

    @Column(length = 20)
    private String manufacturer = "롯데";

    @Column(nullable = false)
    private String imageUrl;

    @OneToOne (
//            mappedBy = "food",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "nutrition_id", nullable = false)
    private Nutrition nutrition;



//    /**
//     * 이미지 URL을 업데이트하는 메소드
//     * @param newImageUrl 스크래핑 등으로 가져온 새 이미지 URL
//     */
//    public void updateImageUrl(String newImageUrl) {
//        this.imageUrl = newImageUrl;
//    }
}



