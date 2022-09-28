package dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString

// "code": 0,
//         "details": "string",
//         "message": "string"

public class ErrorDto {
    int code;
    String details;
    String message;

}
