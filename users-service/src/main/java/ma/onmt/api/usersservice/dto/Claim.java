package ma.onmt.api.usersservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
    private String id;
    private String email;
    List<String> roles;
    private String lastName;
    private String firstName;
    private String userName;


}
