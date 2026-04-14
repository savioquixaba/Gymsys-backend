package Quixaba.dev.Gymsys.Documentacao;

import Quixaba.dev.Gymsys.DTO.InstrutorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Instrutores", description = "Gerenciamento de Instrutores e seus vínculos com Turmas")
public interface InstrutorOpenAPI {

    @Operation(summary = "Criar um novo instrutor", description = "Salva um instrutor no banco e retorna o DTO com o ID gerado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instrutor criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação ou regra de negócio (Ex: Dados inválidos)"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> criarInstrutor(@RequestBody InstrutorDTO instrutorDTO);

    @Operation(summary = "Listar todos os instrutores", description = "Retorna uma lista contendo todos os instrutores cadastrados no banco.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não há dados a serem listados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<List<InstrutorDTO>> listar();

    @Operation(summary = "Buscar instrutor por ID", description = "Busca um instrutor específico informando o seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instrutor encontrado e retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Instrutor não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> listarPorId(@PathVariable Long id);

    @Operation(summary = "Alterar um instrutor", description = "Atualiza os dados de um instrutor existente pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instrutor alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID do instrutor não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> alterarInstrutor(@PathVariable Long id, @RequestBody InstrutorDTO instrutorDTO);

    @Operation(summary = "Deletar um instrutor", description = "Remove um instrutor do banco de dados pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instrutor deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID não encontrado para exclusão"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> deletar(@PathVariable Long id);
}
