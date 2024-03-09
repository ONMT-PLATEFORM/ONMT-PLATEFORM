package ma.onmt.api.usersservice.controller;
///api/v1/regions/{id}/users

import ma.onmt.api.usersservice.dto.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("regions/{id}/users")
public class UserRegionController {

    @GetMapping()
    Page<UserResponse> getUsersByRegion(@PathVariable("id") Long id, Map<String, String> params){
        return null;
    }
}
