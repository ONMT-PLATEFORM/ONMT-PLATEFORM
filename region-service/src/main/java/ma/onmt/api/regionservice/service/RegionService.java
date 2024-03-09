package ma.onmt.api.regionservice.service;

import ma.onmt.api.regionservice.dto.request.RegionRequest;
import ma.onmt.api.regionservice.dto.response.RegionResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface RegionService {
    RegionResponse createRegion(RegionRequest request);

    RegionResponse getRegionById(Long id);

    RegionResponse updateRegion(Long id, RegionRequest request);

    void deleteRegion(Long id);

    Page<RegionResponse> getAllRegions(Map<String, String> params);
}
