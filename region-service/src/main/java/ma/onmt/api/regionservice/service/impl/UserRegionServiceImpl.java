package ma.onmt.api.regionservice.service.impl;

import lombok.RequiredArgsConstructor;
import ma.onmt.api.regionservice.client.UserFeignClient;
import ma.onmt.api.regionservice.dto.response.UserResponse;
import ma.onmt.api.regionservice.repository.RegionRepository;
import ma.onmt.api.regionservice.service.UserRegionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserRegionServiceImpl implements UserRegionService {
    // : CALLING ANOTHER API VIA FEIGN CLIENT
    private UserFeignClient userFeignClient;
    private final RegionRepository regionRepository;
    @Override
    public Page<UserResponse> getUsersByRegion(Long id, Map<String, String> params) {
        //TODO : WE MAY WORK WITH CACHE HERE ..
        this.regionRepository.findById(id).orElseThrow(() -> new RuntimeException("Region with id " + id + " not found"));
        return userFeignClient.getUsersByRegion(id, params);
    }
}
