package ma.onmt.api.regionservice.service;

import ma.onmt.api.regionservice.dto.request.ActivityRequest;
import ma.onmt.api.regionservice.dto.response.ActivityResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ActivityService {
    ActivityResponse createActivity(ActivityRequest request);

    ActivityResponse getActivityById(Long id);

    ActivityResponse updateActivity(Long id, ActivityRequest request);

    void deleteActivity(Long id);

    Page<ActivityResponse> getAllActivities(Map<String, String> params);
}
