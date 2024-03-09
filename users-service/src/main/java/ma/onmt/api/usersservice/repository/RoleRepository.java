package ma.onmt.api.usersservice.repository;

import ma.onmt.api.usersservice.entity.Role;
import ma.onmt.api.usersservice.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
