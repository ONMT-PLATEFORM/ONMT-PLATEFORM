package ma.onmt.api.regionservice.dto.response;

import lombok.Data;

@Data
public class TouristicAttractionResponse {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String image;
    private Long regionId;
}
