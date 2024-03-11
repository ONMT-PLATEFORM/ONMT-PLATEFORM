package ma.onmt.api.regionservice.client;

import ma.onmt.api.regionservice.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "USER-SERVICE")
public interface UserFeignClient {
    @GetMapping("/api/v1/users")
    Page<UserResponse> getAllUsers();
    @GetMapping("/api/v1/regions/{id}/users")
    Page<UserResponse> getUsersByRegion( @PathVariable("id") Long id, @RequestParam Map<String, String> params);
}
