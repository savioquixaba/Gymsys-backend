package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.ContratacaoDTO;
import Quixaba.dev.Gymsys.Services.ContratacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contratacao")
public class ContratacaoController {

    private ContratacaoService contratacaoService;

    public ContratacaoController(ContratacaoService contratacaoService){
        this.contratacaoService = contratacaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarContratacao(@RequestBody ContratacaoDTO contratacaoDTO){
        try {
            ContratacaoDTO novaContrat = contratacaoService.criarContratacao(contratacaoDTO);
            return ResponseEntity.status(HttpStatus.OK).body(novaContrat);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
