package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.TurmaDTO;
import Quixaba.dev.Gymsys.Services.TurmaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/turma")
public class TurmaController {

    private TurmaService turmaService;

    public TurmaController(TurmaService turmaService){
        this.turmaService = turmaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarTurma(@RequestBody TurmaDTO turmaDTO){
        try {
            TurmaDTO novaTurma = turmaService.criarTurma(turmaDTO);
            return ResponseEntity.status(HttpStatus.OK).body(novaTurma);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TurmaDTO>> listarTurmas(){
        try {
           List<TurmaDTO> lista = turmaService.listarTodasTurmas();
           if (lista.isEmpty()){
               log.error("Lista vazia");
               return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
           }
            log.info("lista de alunos: {}",lista);
           return ResponseEntity.status(HttpStatus.OK).body(lista);
        }catch (Exception e) {
            log.error("erro no Servidor", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try {
            TurmaDTO turma = turmaService.turmaPorId(id);
            log.info("turma  :" + id);
            return ResponseEntity.status(HttpStatus.OK).body(turma);
        }catch (RuntimeException e){
            log.error("Erro:",e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            log.error("Erro de servidor",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarTurma(@PathVariable Long id, TurmaDTO turmaDTO){
        try {
            TurmaDTO turmaAlterada = turmaService.alterarTurma(id, turmaDTO);
            return ResponseEntity.status(HttpStatus.OK).body(turmaAlterada);
        }catch (RuntimeException e){
            log.error("Erro: ",e );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            log.error("Erro de servidor",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarTurma(@PathVariable Long id){
        try {
            String existe = turmaService.deletePorId(id);
            log.info("Turma com ID: {} deletado com sucesso!", id );
            return ResponseEntity.status(HttpStatus.OK).body(existe);
        }catch (RuntimeException e){
            log.error("Erro: ",e );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            log.error("Erro de servidor",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
