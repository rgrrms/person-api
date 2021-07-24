package one.digitalinnovation.personapi.entrypoints.converters;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.entrypoints.dto.PersonOutDto;
import one.digitalinnovation.personapi.domain.entities.PersonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ListPersonOutDtoToListPersonEntityConverter implements Converter<List<PersonEntity>, List<PersonOutDto>> {

    private final ModelMapper modelMapper;

    @Override
    public List<PersonOutDto> convert(List<PersonEntity> source) {
        List<PersonOutDto> outDto = new ArrayList<>();
        source.forEach(s -> outDto.add(modelMapper.map(s, PersonOutDto.class)));
        return outDto;
    }
}
