package ma.onmt.api.usersservice.controller;


import lombok.RequiredArgsConstructor;
import ma.onmt.api.usersservice.dto.*;
import ma.onmt.api.usersservice.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<Page<UserResponse>> getAllUsers(
            @RequestParam(required = false) Map<String, String> queryParams
    ) {
        return ResponseEntity.ok(this.userService.getAllUsers(queryParams));
    }
}
