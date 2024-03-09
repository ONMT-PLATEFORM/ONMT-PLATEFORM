package ma.onmt.api.regionservice.repository;

import ma.onmt.api.regionservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // You can add custom queries or methods here if needed
}
