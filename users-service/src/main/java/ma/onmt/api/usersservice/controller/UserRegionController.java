package ma.onmt.api.usersservice.controller;

import lombok.RequiredArgsConstructor;
import ma.onmt.api.usersservice.dto.UserResponse;
import ma.onmt.api.usersservice.service.UserRegionService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/regions/{id}/users")
@RequiredArgsConstructor
public class UserRegionController {

    private final UserRegionService userRegionService;

    @GetMapping
    Page<UserResponse> getUsersByRegion(@PathVariable("id") Long id,@RequestParam(required = false) Map<String, String> params){
        return userRegionService.getUsersByRegion(id, params);
    }
}
