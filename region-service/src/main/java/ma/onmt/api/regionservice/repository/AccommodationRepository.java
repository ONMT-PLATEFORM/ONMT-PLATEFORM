package ma.onmt.api.regionservice.repository;

import ma.onmt.api.regionservice.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,Long> {
}
