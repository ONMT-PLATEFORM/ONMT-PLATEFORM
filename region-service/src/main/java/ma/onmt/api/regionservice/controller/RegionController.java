package ma.onmt.api.regionservice.controller;

import lombok.RequiredArgsConstructor;
import ma.onmt.api.regionservice.dto.request.RegionRequest;
import ma.onmt.api.regionservice.dto.response.RegionResponse;
import ma.onmt.api.regionservice.dto.response.UserResponse;
import ma.onmt.api.regionservice.service.RegionService;
import ma.onmt.api.regionservice.service.UserRegionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RegionController {

    private final  RegionService regionService;
    private final UserRegionService userRegionService;

    @GetMapping
    public ResponseEntity<Page<RegionResponse>> getAllRegions(@RequestParam Map<String, String> params) {
        Page<RegionResponse> regions = regionService.getAllRegions(params);
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<Page<UserResponse>> getUsersByRegion(@PathVariable(name = "id") Long id, @RequestParam(required = false) Map<String, String> params) {
        Page<UserResponse> users = userRegionService.getUsersByRegion(id, params);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegionResponse> getRegionById(@PathVariable Long id) {
        RegionResponse region = regionService.getRegionById(id);
        return ResponseEntity.ok(region);
    }

    @PostMapping
    public ResponseEntity<RegionResponse> createRegion(@RequestBody RegionRequest request) {
        RegionResponse region = regionService.createRegion(request);
        return new ResponseEntity<>(region, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionResponse> updateRegion(@PathVariable Long id, @RequestBody RegionRequest request) {
        RegionResponse region = regionService.updateRegion(id, request);
        return ResponseEntity.ok(region);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
