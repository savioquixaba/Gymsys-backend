package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.TurmaDTO;
import Quixaba.dev.Gymsys.Services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
