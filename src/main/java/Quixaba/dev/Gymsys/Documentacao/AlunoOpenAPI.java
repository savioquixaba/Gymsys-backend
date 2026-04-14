package Quixaba.dev.Gymsys.Documentacao;

import Quixaba.dev.Gymsys.DTO.AlunoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Alunos", description = "Gerenciamento de Alunos cadastrados na academia")
public interface AlunoOpenAPI {

    @Operation(summary = "Criar um novo aluno", description = "Cadastra um novo aluno no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Entidade não processável (Ex: Dados inválidos ou regra de negócio violada)"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<AlunoDTO> criarAluno(@RequestBody AlunoDTO alunoDTO);

    @Operation(summary = "Listar todos os alunos", description = "Retorna uma lista contendo todos os alunos registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso"),
            @ApiResponse(responseCode = "204", description = "A requisição foi bem sucedida, mas não há alunos cadastrados (No Content)"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<List<AlunoDTO>> listarAlunos();

    @Operation(summary = "Buscar aluno por ID", description = "Busca os detalhes de um aluno específico pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado e retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado no banco de dados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<AlunoDTO> buscarPorId(@PathVariable Long id);

    @Operation(summary = "Alterar um aluno", description = "Atualiza os dados de um aluno existente pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado para a alteração"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<AlunoDTO> alterarAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO);

    @Operation(summary = "Deletar um aluno", description = "Remove um aluno do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID do aluno não encontrado para exclusão"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<String> deleteAluno(@PathVariable Long id);
}