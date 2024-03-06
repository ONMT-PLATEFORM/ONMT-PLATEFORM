package ma.onmt.api.regionservice.service.impl;

import lombok.RequiredArgsConstructor;
import ma.onmt.api.regionservice.dto.request.RegionRequest;
import ma.onmt.api.regionservice.dto.response.RegionResponse;
import ma.onmt.api.regionservice.mapper.RegionMapper;
import ma.onmt.api.regionservice.repository.RegionRepository;
import ma.onmt.api.regionservice.service.RegionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

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
        Integer page =Integer.parseInt( params.getOrDefault("page", "0"));
        Integer size = Integer.parseInt(params.getOrDefault("size", "10"));
        PageRequest pageRequest = PageRequest.of(page, size);
        return regionRepository.findAll(pageRequest).map(this.regionMapper::toResponse);
    }
}
