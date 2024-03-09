package ma.onmt.api.regionservice.mapper;

import ma.onmt.api.regionservice.dto.request.EventRequest;
import ma.onmt.api.regionservice.dto.response.EventResponse;
import ma.onmt.api.regionservice.entity.Event;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    @Autowired
    private ModelMapper modelMapper;

    public EventRequest toDto(Event event) {
        return modelMapper.map(event, EventRequest.class);
    }

    public Event toEntityFromRequest(EventRequest request) {
        return modelMapper.map(request, Event.class);
    }

    public EventResponse toResponse(Event event) {
        return modelMapper.map(event, EventResponse.class);
    }
}
