package ma.onmt.api.usersservice.service.impl;

import jakarta.transaction.Transactional;
import ma.onmt.api.usersservice.dto.*;
import ma.onmt.api.usersservice.entity.Role;
import ma.onmt.api.usersservice.entity.User;
import ma.onmt.api.usersservice.enums.RoleName;
import ma.onmt.api.usersservice.exception.business.NotFoundException;
import ma.onmt.api.usersservice.mapper.UserMapper;
import ma.onmt.api.usersservice.repository.RoleRepository;
import ma.onmt.api.usersservice.repository.UserRepository;
import ma.onmt.api.usersservice.service.UserService;
import ma.onmt.api.usersservice.util.JwtUtilities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtilities jwtUtilities;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JwtUtilities jwtUtilities, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtilities = jwtUtilities;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userMapper = UserMapper.INSTANCE;
    }

    @Override
    public BearerToken authenticate(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow(() -> new NotFoundException("User not found"));
        List<String> rolesNames = new ArrayList<>();
        user.getRoles().forEach(r -> rolesNames.add(r.getRoleName()));
        Claim claim = buildClaimFromUser(user);

        String token = jwtUtilities.generateToken(claim, rolesNames);

        return new BearerToken(token, "Bearer");
    }

    private Claim buildClaimFromUser(User user) {
        Claim claim = new Claim();
        claim.setUserName(user.getUsername());
        claim.setEmail(user.getEmail());
        claim.setId(user.getId().toString());
        claim.setLastName(user.getLastName());
        claim.setFirstName(user.getFirstName());
        return claim;
    }

    @Override
    public BearerToken register(RegisterDto registerDto) {
        if (this.userRepository.existsByEmail(registerDto.getEmail())) {
            throw new NotFoundException("email is already taken !");
        }
        User user = new User();

        user.setEmail(registerDto.getEmail());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRegionId(registerDto.getRegionId());
        userRepository.save(user);
        Claim claim = buildClaimFromUser(user);
        String token = jwtUtilities.generateToken(claim, Collections.singletonList(null));
        return new BearerToken(token, "Bearer ");
    }



    @Override
    public Role saveRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public User saverUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Page<UserResponse> getAllUsers(
            Map<String, String> queryParams
    ) {

        int page = Integer.parseInt(queryParams.getOrDefault("page", "0"));
        int size = Integer.parseInt(queryParams.getOrDefault("size", "10"));
        PageRequest pageRequest = PageRequest.of(page, size);
        return this.userRepository.findAllBy(pageRequest).map(userMapper::toDto);
    }
}
