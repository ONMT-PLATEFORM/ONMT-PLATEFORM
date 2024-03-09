package ma.onmt.api.regionservice.mapper;

import ma.onmt.api.regionservice.dto.request.ActivityRequest;
import ma.onmt.api.regionservice.dto.response.ActivityResponse;
import ma.onmt.api.regionservice.entity.Activity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ActivityRequest toDto(Activity activity) {
        return modelMapper.map(activity, ActivityRequest.class);
    }

    public Activity toEntityFromRequest(ActivityRequest request) {
        return modelMapper.map(request, Activity.class);
    }

    public ActivityResponse toResponse(Activity activity) {
        return modelMapper.map(activity, ActivityResponse.class);
    }
}
