package ma.onmt.api.regionservice.dto.request;

import lombok.Data;

@Data
public class AccommodationRequest {
    private String name;
    private String description;
    private String type;
    private String amenities;
    private Long regionId;
}
