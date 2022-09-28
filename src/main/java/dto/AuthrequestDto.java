package dto;
 //"email": "string",
// "password": "string"
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString

public class AuthrequestDto {

    String email;
    String password;

}
