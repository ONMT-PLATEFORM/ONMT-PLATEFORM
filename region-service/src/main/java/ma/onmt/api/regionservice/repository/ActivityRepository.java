package ma.onmt.api.regionservice.repository;

import ma.onmt.api.regionservice.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // You can add custom queries or methods here if needed
}
