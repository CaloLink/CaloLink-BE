package shop.calolink.repository.food;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import shop.calolink.Category;
import shop.calolink.domain.entity.Food;
import shop.calolink.domain.entity.QFood;
import shop.calolink.domain.entity.QNutrition;
import java.util.ArrayList;
import java.util.List;

import static shop.calolink.domain.entity.QFood.food;
import static shop.calolink.domain.entity.QNutrition.nutrition;

@Repository
@RequiredArgsConstructor
public class FoodRepositoryImpl implements FoodRepositoryCustom {

    private final EntityManager em;

    // 검색 API
    // 음식이랑 영양 정보만 조인
    @Override
    public Page<Food> searchFood(Predicate predicate, Pageable pageable) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QFood food = QFood.food;
        QNutrition nutrition = QNutrition.nutrition;

        // 1. 데이터 조회 (Q클래스 사용)
        List<Food> content = queryFactory
                .selectFrom(food) // static import 덕분에 'food'만 쓰면 됨
                .join(food.nutrition, nutrition).fetchJoin() // 1:1 관계 Fetch Join
                .where(predicate)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 2. 카운트 쿼리
        JPAQuery<Long> countQuery = queryFactory
                .select(food.count())
                .from(food)
                .where(predicate);

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    @Override
    public Page<Food> searchFoods(String name, Category category, Pageable pageable) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        // 1. 리스트 조회
        List<Food> content = queryFactory
                .selectFrom(food)
                .leftJoin(food.nutrition, nutrition)
                .where(
                        nameLike(name),       // 동적 조건 1
                        categoryEq(category)  // 동적 조건 2
                )
                .orderBy(getOrderSpecifiers(pageable))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 2. 전체 카운트 조회 (최적화 가능하지만 일단 기본 형태로)
        Long total = queryFactory
                .select(food.count())
                .from(food)
                .where(
                        nameLike(name),
                        categoryEq(category)
                )
                .fetchOne();

        return new PageImpl<>(content, pageable, total != null ? total : 0);
    }

    // 동적 정렬을 위한 헬퍼 메서드
    private OrderSpecifier<?>[] getOrderSpecifiers(Pageable pageable) {
        List<OrderSpecifier<?>> orders = new ArrayList<>();

        if (pageable.getSort() != null) {
            for (Sort.Order order : pageable.getSort()) {
                Order direction = order.isAscending() ? Order.ASC : Order.DESC;
                String prop = order.getProperty();

                System.out.println("정렬 요청 들어옴 - 속성: [" + prop + "], 방향: " + direction);

                // 프론트에서 보낸 정렬 기준(prop)을 Q클래스 필드와 매핑
                switch (prop) {
                    case "kcal":
                        orders.add(new OrderSpecifier<>(direction, food.nutrition.kcal));
                        break;
                    case "protein":
                        orders.add(new OrderSpecifier<>(direction, food.nutrition.protein));
                        break;
                    case "fat":
                        orders.add(new OrderSpecifier<>(direction, food.nutrition.fat));
                        break;
                    case "carb":
                        orders.add(new OrderSpecifier<>(direction, food.nutrition.carb));
                        break;
                    case "sugar":
                        orders.add(new OrderSpecifier<>(direction, food.nutrition.sugar));
                        break;
                    case "sodium":
                        orders.add(new OrderSpecifier<>(direction, food.nutrition.sodium));
                        break;
                    case "name":
                        orders.add(new OrderSpecifier<>(direction, food.name));
                        break;
                    default:
                        // 정렬 조건이 없거나 이상한 필드면 기본적으로 ID 순
                        break;
                }
            }
        }

        return orders.toArray(OrderSpecifier[]::new);
    }

    // 동적 쿼리를 위한 BooleanExpression 메서드들
    private BooleanExpression nameLike(String name) {
        // 이름이 null이거나 빈 문자열이면 조건 무시(null 반환)
        return (name != null && !name.isEmpty()) ? food.name.contains(name) : null;
    }

    private BooleanExpression categoryEq(Category category) {
        // 카테고리가 null이면 조건 무시
        return category != null ? food.category.eq(category) : null;
    }
}
