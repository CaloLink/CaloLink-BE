package shop.calolink.service;

import shop.calolink.domain.dto.FoodSummaryResponse;

import java.util.List;

public interface SearchService {
    List<FoodSummaryResponse> search(String food);

}
