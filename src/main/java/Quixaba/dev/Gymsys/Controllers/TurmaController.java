package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.TurmaDTO;
import Quixaba.dev.Gymsys.Services.TurmaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

}
