package ma.onmt.api.regionservice.service;

import ma.onmt.api.regionservice.dto.request.TouristicAttractionRequest;
import ma.onmt.api.regionservice.dto.response.TouristicAttractionResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface TouristicAttractionService {
    TouristicAttractionResponse createTouristicAttraction(TouristicAttractionRequest request);

    TouristicAttractionResponse getTouristicAttractionById(Long id);

    TouristicAttractionResponse updateTouristicAttraction(Long id, TouristicAttractionRequest request);

    void deleteTouristicAttraction(Long id);

    Page<TouristicAttractionResponse> getAllTouristicAttractions(Map<String, String> params);
}
