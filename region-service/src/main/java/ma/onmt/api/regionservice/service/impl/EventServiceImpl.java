package ma.onmt.api.regionservice.service.impl;

import ma.onmt.api.regionservice.dto.request.EventRequest;
import ma.onmt.api.regionservice.dto.response.EventResponse;
import ma.onmt.api.regionservice.service.EventService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public EventResponse createEvent(EventRequest request) {
        return null;
    }

    @Override
    public EventResponse getEventById(Long id) {
        return null;
    }

    @Override
    public EventResponse updateEvent(Long id, EventRequest request) {
        return null;
    }

    @Override
    public void deleteEvent(Long id) {

    }

    @Override
    public Page<EventResponse> getAllEvents(Map<String, String> params) {
        return null;
    }
}
