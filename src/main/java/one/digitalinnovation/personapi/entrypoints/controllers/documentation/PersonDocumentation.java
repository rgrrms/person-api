package one.digitalinnovation.personapi.entrypoints.controllers.documentation;

import io.swagger.annotations.*;
import one.digitalinnovation.personapi.entrypoints.dto.PersonOutDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api( tags = "DIO",
        produces = "application/json",
        consumes = "application/json"
)
public interface PersonDocumentation {

    @ApiOperation(value = "Buscas todas as pessoas da tabela person", tags = "DIO", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso ao buscar todas as pessoas", response = ResponseEntity.class),
            @ApiResponse(code = 401, message = "Busca não autorizada.", response = ResponseEntity.class),
            @ApiResponse(code = 404, message = "Pessoas não encontradas.", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Erro na busca dos dados", response = ResponseEntity.class)
    })
    public ResponseEntity<List<PersonOutDto>> getAllPerson();

}
