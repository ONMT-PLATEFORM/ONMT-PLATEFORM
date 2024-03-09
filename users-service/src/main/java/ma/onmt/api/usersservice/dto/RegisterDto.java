package ma.onmt.api.usersservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto implements Serializable {

    String email;
    String password;
    String firstName;
    String lastName;
    String regionId;
//    String userRole;


}
