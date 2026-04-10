package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.PlanoDTO;
import Quixaba.dev.Gymsys.Services.PlanoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/plano")
public class PlanoController {

    private PlanoService planoService;

    public PlanoController(PlanoService planoService){
        this.planoService = planoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<PlanoDTO> criarPlano(PlanoDTO planoDTO){
        try {
            PlanoDTO novoPlano = planoService.criarPlano(planoDTO);
            return ResponseEntity.status(HttpStatus.OK).body(novoPlano);
        }catch (RuntimeException e){
            log.error("alguma informação na criação do plano está errada;");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch ( Exception e){
            log.error("erro de servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/listar")
    public ResponseEntity<List<PlanoDTO>> listar(){
        try {
            List<PlanoDTO> listar = planoService.listarTodos();
            return ResponseEntity.status(HttpStatus.OK).body(listar);
        }catch (RuntimeException e){
            log.error("Nenhuma informação encontrada");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            log.error("Erro no servidor");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
