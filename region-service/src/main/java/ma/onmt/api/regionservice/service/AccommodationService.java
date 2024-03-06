package ma.onmt.api.regionservice.service;

import ma.onmt.api.regionservice.dto.request.AccommodationRequest;
import ma.onmt.api.regionservice.dto.response.AccommodationResponse;
import org.springframework.data.domain.Page;

import java.util.Map;


public interface AccommodationService {
    AccommodationResponse createAccommodation(AccommodationRequest request);

    AccommodationResponse getAccommodationById(Long id);

    AccommodationResponse updateAccommodation(Long id, AccommodationRequest request);

    void deleteAccommodation(Long id);

    Page<AccommodationResponse> getAllAccommodations(Map<String, String> params);
}
