package ma.onmt.api.regionservice.service;

import ma.onmt.api.regionservice.dto.response.UserResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface UserRegionService {

    Page<UserResponse> getUsersByRegion(Long id, Map<String, String> params);
}
