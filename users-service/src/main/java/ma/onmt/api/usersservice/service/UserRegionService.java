package ma.onmt.api.usersservice.service;

import ma.onmt.api.usersservice.dto.UserResponse;
import org.springframework.data.domain.Page;
import java.util.Map;

public interface UserRegionService {
    Page<UserResponse> getUsersByRegion(Long id, Map<String, String> params);
    Page<UserResponse> getAllUsers();
}
