package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.AlunoDTO;
import Quixaba.dev.Gymsys.Services.AlunoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<AlunoDTO> criarAluno(@RequestBody AlunoDTO alunoDTO){
        try {
            AlunoDTO novoAluno = alunoService.criarAluno(alunoDTO);
            log.info("Aluno criado com o id: {}", novoAluno.getId());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(novoAluno);

        }catch (IllegalArgumentException exception){
            log.error("Erro na criação do aluno, verifique os dados novamente;");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }catch (RuntimeException e){
            log.error("Erro no servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("listar-alunos")
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {
        try {
            List<AlunoDTO> lista = alunoService.listarTodosAlunos();
            if (!lista.isEmpty()) {
                log.info("lista de alunos: {}",lista);
                return ResponseEntity.status(HttpStatus.OK).body(lista);
            }
            log.error("Lista vazia");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (RuntimeException e) {
            log.error("Erro no servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
