package Quixaba.dev.Gymsys.Documentacao;

import Quixaba.dev.Gymsys.DTO.ContratacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Contratações", description = "Gerenciamento de vínculos entre Alunos e Planos da academia")
public interface ContratacaoOpenAPI {

    @Operation(summary = "Criar nova contratação", description = "Vincula um aluno a um plano especificando datas de início e fim.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contratação criada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno ou Plano informado não existe no banco de dados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> criarContratacao(@RequestBody ContratacaoDTO contratacaoDTO);

    @Operation(summary = "Listar todas as contratações", description = "Retorna uma lista com todas as contratações registradas no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de contratações retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não há dados de contratações a serem listados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<List<ContratacaoDTO>> listar();

    @Operation(summary = "Buscar contratação por ID", description = "Retorna os detalhes de uma contratação específica pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contratação encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID da contratação não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> listarId(@PathVariable Long id);

    @Operation(summary = "Alterar uma contratação", description = "Atualiza os dados de uma contratação existente (ex: mudar o plano ou as datas).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contratação alterada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Contratação, Aluno ou Plano não encontrados para a alteração"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> alterarContratacao(@PathVariable Long id, @RequestBody ContratacaoDTO contratacaoDTO);

    @Operation(summary = "Deletar uma contratação", description = "Remove um registro de contratação pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contratação deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "ID da contratação não encontrado para exclusão"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    ResponseEntity<?> deletarContratacao(@PathVariable Long id);
}