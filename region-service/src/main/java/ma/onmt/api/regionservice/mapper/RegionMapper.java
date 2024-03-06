package ma.onmt.api.regionservice.mapper;

import ma.onmt.api.regionservice.dto.request.RegionRequest;
import ma.onmt.api.regionservice.dto.response.RegionResponse;
import ma.onmt.api.regionservice.entity.Region;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RegionRequest toDto(Region region) {
        return modelMapper.map(region, RegionRequest.class);
    }

    public Region toEntityFromRequest(RegionRequest request) {
        return modelMapper.map(request, Region.class);
    }

    public RegionResponse toResponse(Region region) {
        return modelMapper.map(region, RegionResponse.class);
    }
}
