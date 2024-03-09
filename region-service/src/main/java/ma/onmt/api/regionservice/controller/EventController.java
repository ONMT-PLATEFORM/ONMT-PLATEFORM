package ma.onmt.api.regionservice.controller;

import lombok.RequiredArgsConstructor;
import ma.onmt.api.regionservice.dto.request.EventRequest;
import ma.onmt.api.regionservice.dto.response.EventResponse;
import ma.onmt.api.regionservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final  EventService eventService;

    @GetMapping
    public ResponseEntity<Page<EventResponse>> getAllEvents(@RequestParam Map<String, String> params) {
        Page<EventResponse> events = eventService.getAllEvents(params);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
        EventResponse event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest request) {
        EventResponse event = eventService.createEvent(request);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponse> updateEvent(@PathVariable Long id, @RequestBody EventRequest request) {
        EventResponse event = eventService.updateEvent(id, request);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
