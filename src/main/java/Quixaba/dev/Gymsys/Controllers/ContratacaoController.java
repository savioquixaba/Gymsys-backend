package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.ContratacaoDTO;
import Quixaba.dev.Gymsys.Services.ContratacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @GetMapping("/listar")
    public ResponseEntity<List<ContratacaoDTO>> listar(){
        try {
            List<ContratacaoDTO> lista = contratacaoService.listarContratacao();
            log.info("Lista: {}", lista);
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        }catch (RuntimeException e){
            log.info("Não existe informações a serem listadas");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception e){
            log.error("Erro de servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarId(@PathVariable Long id){
        try {
            ContratacaoDTO listar = contratacaoService.listarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(listar);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
