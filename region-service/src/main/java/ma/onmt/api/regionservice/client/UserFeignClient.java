package ma.onmt.api.regionservice.client;

import ma.onmt.api.regionservice.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "USER-SERVICE")
public interface UserFeignClient {
    @GetMapping("/api/v1/users")
    Page<UserResponse> getAllUsers();

    Page<UserResponse> getUsersByRegion(Long id, Map<String, String> params);
}
