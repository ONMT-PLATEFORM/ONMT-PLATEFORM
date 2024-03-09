package ma.onmt.api.usersservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "REGION-SERVICE")
public interface RegionFeignClient {
   //TODO: Implementing Feign ClientT TO CALL REGION-SERVICE
}
