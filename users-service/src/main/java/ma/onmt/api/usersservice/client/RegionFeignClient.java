package ma.onmt.api.usersservice.client;

import ma.onmt.api.usersservice.dto.RegionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "REGION-SERVICE")
public interface RegionFeignClient {
   //: Implementing Feign ClientT TO CALL REGION-SERVICE

    // : GET USER REGION INFORMATION
    @GetMapping("api/v1/regions/{id}")
    RegionResponse getRegion(@PathVariable("id") Long id);

}
