package ma.onmt.api.regionservice.dto.request;

import lombok.Data;

@Data
public class TouristicAttractionRequest {
    private String name;
    private String description;
    private String location;
    private String image;
    private Long regionId;
}
