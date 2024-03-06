package ma.onmt.api.regionservice.repository;

import ma.onmt.api.regionservice.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    // You can add custom queries or methods here if needed
}
