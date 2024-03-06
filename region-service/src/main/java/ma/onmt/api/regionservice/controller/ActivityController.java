package ma.onmt.api.regionservice.controller;

import lombok.RequiredArgsConstructor;
import ma.onmt.api.regionservice.dto.request.ActivityRequest;
import ma.onmt.api.regionservice.dto.response.ActivityResponse;
import ma.onmt.api.regionservice.service.ActivityService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {


    private final  ActivityService activityService;

    @GetMapping
    public ResponseEntity<Page<ActivityResponse>> getAllActivities(@RequestParam Map<String, String> params) {
        Page<ActivityResponse> activities = activityService.getAllActivities(params);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityResponse> getActivityById(@PathVariable Long id) {
        ActivityResponse activity = activityService.getActivityById(id);
        return ResponseEntity.ok(activity);
    }

    @PostMapping
    public ResponseEntity<ActivityResponse> createActivity(@RequestBody ActivityRequest request) {
        ActivityResponse activity = activityService.createActivity(request);
        return new ResponseEntity<>(activity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityResponse> updateActivity(@PathVariable Long id, @RequestBody ActivityRequest request) {
        ActivityResponse activity = activityService.updateActivity(id, request);
        return ResponseEntity.ok(activity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
