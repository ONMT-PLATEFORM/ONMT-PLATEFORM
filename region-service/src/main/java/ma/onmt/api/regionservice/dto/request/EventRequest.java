package ma.onmt.api.regionservice.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventRequest {
    private String name;
    private String description;
    private LocalDate date;
    private String location;
    private Long regionId;
}
