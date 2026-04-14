package Quixaba.dev.Gymsys.Documentacao;



import Quixaba.dev.Gymsys.DTO.PlanoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Tag(name = "Planos", description = "Gerenciamento de Planos oferecidos pela academia")
public interface PlanoOpenAPI {

    @Operation(summary = "Criar um novo plano", description = "Salva um novo plano no banco de dados (ex: Mensal, Anual).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação ou informações incorretas na requisição"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<PlanoDTO> criarPlano(@RequestBody PlanoDTO planoDTO);

    @Operation(summary = "Listar todos os planos", description = "Retorna uma lista contendo todos os planos disponíveis.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de planos retornada com sucesso"),
            @ApiResponse(responseCode = "204", description = "A requisição foi bem sucedida, mas não há planos cadastrados (No Content)"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<List<PlanoDTO>> listar();

    @Operation(summary = "Buscar plano por ID", description = "Busca os detalhes de um plano específico informando o seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano encontrado e retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Plano não encontrado no banco de dados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> listarPorId(@PathVariable Long id);

    @Operation(summary = "Alterar um plano", description = "Atualiza os dados (como preço e duração) de um plano existente pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID do plano não encontrado para a alteração"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> alterarPlano(@PathVariable Long id, @RequestBody PlanoDTO planoDTO);

    @Operation(summary = "Deletar um plano", description = "Remove um plano do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plano deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID do plano não encontrado para exclusão"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> deletePlano(@PathVariable Long id);
}