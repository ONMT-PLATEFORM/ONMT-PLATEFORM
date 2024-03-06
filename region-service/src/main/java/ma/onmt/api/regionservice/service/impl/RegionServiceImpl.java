package ma.onmt.api.regionservice.service.impl;

import ma.onmt.api.regionservice.dto.request.RegionRequest;
import ma.onmt.api.regionservice.dto.response.RegionResponse;
import ma.onmt.api.regionservice.service.RegionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegionServiceImpl implements RegionService {
    @Override
    public RegionResponse createRegion(RegionRequest request) {
        return null;
    }

    @Override
    public RegionResponse getRegionById(Long id) {
        return null;
    }

    @Override
    public RegionResponse updateRegion(Long id, RegionRequest request) {
        return null;
    }

    @Override
    public void deleteRegion(Long id) {

    }

    @Override
    public Page<RegionResponse> getAllRegions(Map<String, String> params) {
        return null;
    }
}
