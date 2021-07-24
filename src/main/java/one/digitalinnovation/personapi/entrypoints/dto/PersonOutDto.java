package one.digitalinnovation.personapi.entrypoints.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonOutDto {

    private Long id;
    private String name;
    private Long age;
    private String state;
}
