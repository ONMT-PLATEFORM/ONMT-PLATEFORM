package ma.onmt.api.regionservice.mapper;

import ma.onmt.api.regionservice.dto.request.AccommodationRequest;
import ma.onmt.api.regionservice.dto.response.AccommodationResponse;
import ma.onmt.api.regionservice.entity.Accommodation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccommodationMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AccommodationRequest toDto(Accommodation accommodation) {
        return modelMapper.map(accommodation, AccommodationRequest.class);
    }

    public Accommodation toEntityFromRequest(AccommodationRequest request) {
        return modelMapper.map(request, Accommodation.class);
    }

    public AccommodationResponse toResponse(Accommodation accommodation) {
        return modelMapper.map(accommodation, AccommodationResponse.class);
    }
}
