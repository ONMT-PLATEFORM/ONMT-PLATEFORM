package ma.onmt.api.usersservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.onmt.api.usersservice.dto.UserResponse;
import ma.onmt.api.usersservice.mapper.UserMapper;
import ma.onmt.api.usersservice.repository.UserRepository;
import ma.onmt.api.usersservice.service.UserRegionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
@Transactional
public class UserRegionServiceImpl implements UserRegionService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserRegionServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = UserMapper.INSTANCE;
    }

    @Override
    public Page<UserResponse> getUsersByRegion(Long id, Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "0"));
        int size = Integer.parseInt(params.getOrDefault("size", "10"));
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<UserResponse> userResponses =  this.userRepository.findAllByRegionId(id.toString(),pageRequest).map(userMapper::toDto);
        System.out.println(userResponses.get().count());
        return userResponses;

    }

    @Override
    public Page<UserResponse> getAllUsers() {
        return null;
    }
}
