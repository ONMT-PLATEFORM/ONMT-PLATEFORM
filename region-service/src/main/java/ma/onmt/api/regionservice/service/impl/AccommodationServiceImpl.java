package ma.onmt.api.regionservice.service.impl;

import ma.onmt.api.regionservice.dto.request.AccommodationRequest;
import ma.onmt.api.regionservice.dto.response.AccommodationResponse;
import ma.onmt.api.regionservice.service.AccommodationService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    @Override
    public AccommodationResponse createAccommodation(AccommodationRequest request) {
        return null;
    }

    @Override
    public AccommodationResponse getAccommodationById(Long id) {
        return null;
    }

    @Override
    public AccommodationResponse updateAccommodation(Long id, AccommodationRequest request) {
        return null;
    }

    @Override
    public void deleteAccommodation(Long id) {

    }

    @Override
    public Page<AccommodationResponse> getAllAccommodations(Map<String, String> params) {
        return null;
    }
}
