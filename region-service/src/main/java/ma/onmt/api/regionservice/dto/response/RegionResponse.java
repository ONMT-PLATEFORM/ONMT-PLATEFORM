package ma.onmt.api.regionservice.dto.response;

import lombok.Data;

@Data
public class RegionResponse {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String area;
    private String gdp;
    private String population;
}
