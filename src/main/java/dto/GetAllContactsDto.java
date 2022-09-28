package dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class GetAllContactsDto {
    List<ContactDto> contacts;

}
