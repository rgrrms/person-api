package one.digitalinnovation.personapi.entrypoints.controllers.documentation;

import io.swagger.annotations.*;
import one.digitalinnovation.personapi.entrypoints.dto.PersonIdOutDto;
import one.digitalinnovation.personapi.entrypoints.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
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
    public ResponseEntity<List<PersonDto>> getAllPerson();

    @ApiOperation(value = "Buscas uma pessoas da tabela person por id", tags = "DIO", httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso ao buscar a pessoa", response = ResponseEntity.class),
            @ApiResponse(code = 401, message = "Busca não autorizada.", response = ResponseEntity.class),
            @ApiResponse(code = 404, message = "Pessoa não encontrada.", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Erro na busca dos dados", response = ResponseEntity.class)
    })
    public ResponseEntity<PersonDto> getPerson(
            @ApiParam(name = "id", value = "id da pessoa", required = true) @PathVariable Long id
    );

    @ApiOperation(value = "Salva uma pessoa na tabela person", tags = "DIO", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso ao salvar a pessoa", response = ResponseEntity.class),
            @ApiResponse(code = 401, message = "Criação não autorizada.", response = ResponseEntity.class),
            @ApiResponse(code = 404, message = "Dados não encontrados.", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Erro na criação da pessoa", response = ResponseEntity.class)
    })
    public PersonIdOutDto savePerson(
            @ApiParam(name = "person", value = "dados de uma pessoa", required = true) @RequestBody PersonDto person
    );

    @ApiOperation(value = "Altera uma pessoa na tabela person", tags = "DIO", httpMethod = "PUT")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso ao alterar a pessoa", response = ResponseEntity.class),
            @ApiResponse(code = 401, message = "Alteração não autorizada.", response = ResponseEntity.class),
            @ApiResponse(code = 404, message = "Dados não encontrados.", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Erro na alteração da pessoa", response = ResponseEntity.class)
    })
    public PersonIdOutDto alterPerson(
            @ApiParam(name = "person", value = "dados de uma pessoa", required = true) @RequestBody @Valid PersonDto person,
            @ApiParam(name = "id", value = "id da pessoa", required = true) @PathVariable Long id
    );

    @ApiOperation(value = "Exclui uma pessoa na tabela person", tags = "DIO", httpMethod = "DELETE")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso ao apagar a pessoa", response = ResponseEntity.class),
            @ApiResponse(code = 401, message = "Ação não autorizada.", response = ResponseEntity.class),
            @ApiResponse(code = 404, message = "Dados não encontrados.", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Erro ao apagar uma pessoa", response = ResponseEntity.class)
    })
    public ResponseEntity deletePerson(
            @ApiParam(name = "id", value = "id da pessoa", required = true) @PathVariable Long id
    );
}
