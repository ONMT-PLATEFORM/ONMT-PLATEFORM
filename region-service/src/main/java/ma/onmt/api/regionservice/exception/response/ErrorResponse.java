package ma.onmt.api.regionservice.exception.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse {

    @Schema(description = "Code http de l'erreur")
    private String code;

    @Schema(description = "Statut par defaut du code http")
    private String status;

    @Schema(description = "Detail de l'erreur")
    private String message;
    @Schema(description = "Detail de l'erreur ce form de Map<String , String >")
    private Map<String,String> details  = new HashMap<>();


    @Schema()
    private List<String> parameters = new ArrayList<>();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime horodatage ;


    public ErrorResponse() {
        horodatage = LocalDateTime.now();
    }

    public ErrorResponse(String code, HttpStatus status, String message) {
        this();
        this.status = status.toString();
        this.code = code;
        this.message = message;
    }


}

