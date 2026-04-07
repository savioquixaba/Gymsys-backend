package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.AlunoDTO;
import Quixaba.dev.Gymsys.Services.AlunoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(novoAluno);
        }catch (IllegalArgumentException exception){
            log.error("Erro na criação do aluno, verifique os dados novamente;");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }






}
