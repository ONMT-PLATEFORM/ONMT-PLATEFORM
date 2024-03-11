package ma.onmt.api.usersservice.repository;


import ma.onmt.api.usersservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Page<User> findAllBy(Pageable pageable);
    Page<User> findAllByRegionId(String regionId, Pageable pageable);


}
