package shop.calolink.domain.dto;

public record FoodSummaryResponse(
        Long id,
        String name,
        Integer carbs,
        Integer protein,
        Integer fat,
        String imageUrl
) {
}
