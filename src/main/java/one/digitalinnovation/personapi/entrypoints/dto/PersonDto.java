package one.digitalinnovation.personapi.entrypoints.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

    private Long id;

    @NotBlank(message = "{person.name}")
    private String name;

    @NotNull(message = "{person.age}")
    private Long age;

    @NotBlank
    @Size(min = 2, max = 2)
    private String state;
}
