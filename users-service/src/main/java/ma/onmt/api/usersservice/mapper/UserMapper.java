package ma.onmt.api.usersservice.mapper;

import ma.onmt.api.usersservice.dto.UserResponse;
import ma.onmt.api.usersservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse toDto(User user);

    User toEntity(UserResponse userResponse);
}
