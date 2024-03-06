package ma.onmt.api.regionservice.controller;

import lombok.RequiredArgsConstructor;
import ma.onmt.api.regionservice.dto.request.TouristicAttractionRequest;
import ma.onmt.api.regionservice.dto.response.TouristicAttractionResponse;
import ma.onmt.api.regionservice.service.TouristicAttractionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/touristic-attractions")
@RequiredArgsConstructor
public class TouristicAttractionController {


    private final TouristicAttractionService touristicAttractionService;

    @GetMapping
    public ResponseEntity<Page<TouristicAttractionResponse>> getAllTouristicAttractions(@RequestParam Map<String, String> params) {
        Page<TouristicAttractionResponse> attractions = touristicAttractionService.getAllTouristicAttractions(params);
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TouristicAttractionResponse> getTouristicAttractionById(@PathVariable Long id) {
        TouristicAttractionResponse attraction = touristicAttractionService.getTouristicAttractionById(id);
        return ResponseEntity.ok(attraction);
    }

    @PostMapping
    public ResponseEntity<TouristicAttractionResponse> createTouristicAttraction(@RequestBody TouristicAttractionRequest request) {
        TouristicAttractionResponse attraction = touristicAttractionService.createTouristicAttraction(request);
        return new ResponseEntity<>(attraction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TouristicAttractionResponse> updateTouristicAttraction(@PathVariable Long id, @RequestBody TouristicAttractionRequest request) {
        TouristicAttractionResponse attraction = touristicAttractionService.updateTouristicAttraction(id, request);
        return ResponseEntity.ok(attraction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTouristicAttraction(@PathVariable Long id) {
        touristicAttractionService.deleteTouristicAttraction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
