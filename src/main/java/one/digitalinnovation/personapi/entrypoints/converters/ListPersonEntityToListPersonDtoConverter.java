package one.digitalinnovation.personapi.entrypoints.converters;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.entrypoints.dto.PersonDto;
import one.digitalinnovation.personapi.domain.entities.PersonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ListPersonEntityToListPersonDtoConverter implements Converter<List<PersonEntity>, List<PersonDto>> {

    private final ModelMapper modelMapper;

    @Override
    public List<PersonDto> convert(List<PersonEntity> source) {
        List<PersonDto> outDto = new ArrayList<>();
        source.forEach(s -> outDto.add(modelMapper.map(s, PersonDto.class)));
        return outDto;
    }
}
