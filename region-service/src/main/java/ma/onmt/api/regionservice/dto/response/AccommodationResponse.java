package ma.onmt.api.regionservice.dto.response;

import lombok.Data;

@Data
public class AccommodationResponse {
    private Long id;
    private String name;
    private String description;
    private String type;
    private String amenities;
    private Long regionId;
}
