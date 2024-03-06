package ma.onmt.api.regionservice.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private String location;
    private Long regionId;
}
