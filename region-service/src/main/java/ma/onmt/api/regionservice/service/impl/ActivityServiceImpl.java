package ma.onmt.api.regionservice.service.impl;

import ma.onmt.api.regionservice.dto.request.ActivityRequest;
import ma.onmt.api.regionservice.dto.response.ActivityResponse;
import ma.onmt.api.regionservice.service.ActivityService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Override
    public ActivityResponse createActivity(ActivityRequest request) {
        return null;
    }

    @Override
    public ActivityResponse getActivityById(Long id) {
        return null;
    }

    @Override
    public ActivityResponse updateActivity(Long id, ActivityRequest request) {
        return null;
    }

    @Override
    public void deleteActivity(Long id) {

    }

    @Override
    public Page<ActivityResponse> getAllActivities(Map<String, String> params) {
        return null;
    }
}
