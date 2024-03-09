package ma.onmt.api.usersservice.dto;

import lombok.Data;

@Data

public class RegionResponse {
    private Long id;
    private String name;
    private String description;
    private String area;
    private String gdp;
    private String population;
}
