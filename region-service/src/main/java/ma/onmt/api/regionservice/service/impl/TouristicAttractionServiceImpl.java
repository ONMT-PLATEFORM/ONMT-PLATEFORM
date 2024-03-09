package ma.onmt.api.regionservice.service.impl;

import ma.onmt.api.regionservice.dto.request.TouristicAttractionRequest;
import ma.onmt.api.regionservice.dto.response.TouristicAttractionResponse;
import ma.onmt.api.regionservice.service.TouristicAttractionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TouristicAttractionServiceImpl implements TouristicAttractionService {
    @Override
    public TouristicAttractionResponse createTouristicAttraction(TouristicAttractionRequest request) {
        return null;
    }

    @Override
    public TouristicAttractionResponse getTouristicAttractionById(Long id) {
        return null;
    }

    @Override
    public TouristicAttractionResponse updateTouristicAttraction(Long id, TouristicAttractionRequest request) {
        return null;
    }

    @Override
    public void deleteTouristicAttraction(Long id) {

    }

    @Override
    public Page<TouristicAttractionResponse> getAllTouristicAttractions(Map<String, String> params) {
        return null;
    }
}
