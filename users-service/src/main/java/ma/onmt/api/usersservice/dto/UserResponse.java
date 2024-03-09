package ma.onmt.api.usersservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    Integer id;
    String firstName;
    String lastName;
    String email;
    String password;
    String userRole;

}
