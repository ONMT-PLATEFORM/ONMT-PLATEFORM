package ma.onmt.api.regionservice.service.impl;

import jakarta.transaction.Transactional;
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
@Transactional
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    @Override
    public RegionResponse createRegion(RegionRequest request) {
        return this.regionMapper.toResponse(this.regionRepository.save(this.regionMapper.toEntityFromRequest(request)));
    }

    @Override
    public RegionResponse getRegionById(Long id) {
        return this.regionRepository.findById(id).map(this.regionMapper::toResponse).orElseThrow(() -> new RuntimeException("Region with id " + id + " not found"));

    }

    @Override
    public RegionResponse updateRegion(Long id, RegionRequest request) {
        return this.regionRepository.findById(id).map(region -> {
            region.setName(request.getName());
            return this.regionMapper.toResponse(this.regionRepository.save(region));
        }).orElseThrow(() -> new RuntimeException("Region with id " + id + " not found"));
    }

    @Override
    public void deleteRegion(Long id) {
        this.regionRepository.deleteById(id);
    }

    @Override
    public Page<RegionResponse> getAllRegions(Map<String, String> params) {
        Integer page =Integer.parseInt( params.getOrDefault("page", "0"));
        Integer size = Integer.parseInt(params.getOrDefault("size", "10"));
        PageRequest pageRequest = PageRequest.of(page, size);
        return regionRepository.findAll(pageRequest).map(this.regionMapper::toResponse);
    }
}
