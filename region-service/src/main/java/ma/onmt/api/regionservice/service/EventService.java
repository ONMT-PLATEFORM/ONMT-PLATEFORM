package ma.onmt.api.regionservice.service;

import ma.onmt.api.regionservice.dto.request.EventRequest;
import ma.onmt.api.regionservice.dto.response.EventResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface EventService {
    EventResponse createEvent(EventRequest request);

    EventResponse getEventById(Long id);

    EventResponse updateEvent(Long id, EventRequest request);

    void deleteEvent(Long id);

    Page<EventResponse> getAllEvents(Map<String, String> params);
}
