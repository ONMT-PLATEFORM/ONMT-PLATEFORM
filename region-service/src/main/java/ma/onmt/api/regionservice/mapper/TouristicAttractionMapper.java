package ma.onmt.api.regionservice.mapper;

import ma.onmt.api.regionservice.dto.request.TouristicAttractionRequest;
import ma.onmt.api.regionservice.dto.response.TouristicAttractionResponse;
import ma.onmt.api.regionservice.entity.TouristicAttraction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TouristicAttractionMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TouristicAttractionRequest toDto(TouristicAttraction attraction) {
        return modelMapper.map(attraction, TouristicAttractionRequest.class);
    }

    public TouristicAttraction toEntityFromRequest(TouristicAttractionRequest request) {
        return modelMapper.map(request, TouristicAttraction.class);
    }

    public TouristicAttractionResponse toResponse(TouristicAttraction attraction) {
        return modelMapper.map(attraction, TouristicAttractionResponse.class);
    }
}
