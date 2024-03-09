package ma.onmt.api.regionservice.controller;

import lombok.RequiredArgsConstructor;
import ma.onmt.api.regionservice.dto.request.AccommodationRequest;
import ma.onmt.api.regionservice.dto.response.AccommodationResponse;
import ma.onmt.api.regionservice.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/accommodations")
@RequiredArgsConstructor
public class AccommodationController {

    private final  AccommodationService accommodationService;

    @GetMapping
    public ResponseEntity<Page<AccommodationResponse>> getAllAccommodations(
            @RequestParam Map<String, String> params
            ) {
        Page<AccommodationResponse> accommodations = accommodationService.getAllAccommodations(params);
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccommodationResponse> getAccommodationById(@PathVariable Long id) {
        AccommodationResponse accommodation = accommodationService.getAccommodationById(id);
        return ResponseEntity.ok(accommodation);
    }

    @PostMapping
    public ResponseEntity<AccommodationResponse> createAccommodation(@RequestBody AccommodationRequest request) {
        AccommodationResponse accommodation = accommodationService.createAccommodation(request);
        return new ResponseEntity<>(accommodation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccommodationResponse> updateAccommodation(@PathVariable Long id, @RequestBody AccommodationRequest request) {
        AccommodationResponse accommodation = accommodationService.updateAccommodation(id, request);
        return ResponseEntity.ok(accommodation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable Long id) {
        accommodationService.deleteAccommodation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
