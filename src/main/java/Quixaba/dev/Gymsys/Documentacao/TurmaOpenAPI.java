package Quixaba.dev.Gymsys.Documentacao;


import Quixaba.dev.Gymsys.DTO.TurmaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Turmas", description = "Gerenciamento de Turmas e vínculos com Instrutores")
public interface TurmaOpenAPI {

    @Operation(summary = "Criar uma nova turma", description = "Salva uma turma no banco de dados e retorna os dados cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turma criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação (Ex: Instrutor vinculado não existe)"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> criarTurma(@RequestBody TurmaDTO turmaDTO);

    @Operation(summary = "Listar todas as turmas", description = "Retorna uma lista contendo todas as turmas cadastradas. Caso não haja nenhuma, retorna sem conteúdo (204).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de turmas retornada com sucesso"),
            @ApiResponse(responseCode = "204", description = "A requisição foi bem sucedida, mas a lista está vazia (No Content)"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<List<TurmaDTO>> listarTurmas();

    @Operation(summary = "Buscar turma por ID", description = "Busca os detalhes de uma turma específica pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turma encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Turma não encontrada no banco de dados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> buscarPorId(@PathVariable Long id);

    @Operation(summary = "Alterar uma turma", description = "Atualiza os dados de uma turma existente pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turma alterada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Turma ou Instrutor não encontrados para a alteração"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> alterarTurma(@PathVariable Long id, @RequestBody TurmaDTO turmaDTO);

    @Operation(summary = "Deletar uma turma", description = "Remove uma turma do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turma deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID da turma não encontrado para exclusão"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> deletarTurma(@PathVariable Long id);
}