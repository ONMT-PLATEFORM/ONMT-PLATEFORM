package ma.onmt.api.regionservice.repository;

import ma.onmt.api.regionservice.entity.TouristicAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristicAttractionRepository extends JpaRepository<TouristicAttraction, Long> {
    // You can add custom queries or methods here if needed
}
