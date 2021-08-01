package one.digitalinnovation.personapi.entrypoints.converters;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.domain.entities.PersonEntity;
import one.digitalinnovation.personapi.entrypoints.dto.PersonDto;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonInDtoToPersonEntityConverter implements Converter<PersonDto, PersonEntity> {

    private final ModelMapper modelMapper;

    @Override
    public PersonEntity convert(PersonDto source) {
        return modelMapper.map(source, PersonEntity.class);
    }
}
