package ma.onmt.api.regionservice.dto.request;

import lombok.Data;

@Data
public class RegionRequest {
    private String name;
    private String description;
    private String area;
    private String gdp;
    private String population;
}
