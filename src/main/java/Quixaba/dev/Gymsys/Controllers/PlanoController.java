package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.PlanoDTO;
import Quixaba.dev.Gymsys.Documentacao.PlanoOpenAPI;
import Quixaba.dev.Gymsys.Services.PlanoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/plano")
public class PlanoController implements PlanoOpenAPI {

    private PlanoService planoService;

    public PlanoController(PlanoService planoService){
        this.planoService = planoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<PlanoDTO> criarPlano(@RequestBody PlanoDTO planoDTO){
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

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        try {
            PlanoDTO plano = planoService.listarPorId(id);
            log.info("Plano listado: {}", plano);
            return ResponseEntity.status(HttpStatus.OK).body(plano);
        }catch (RuntimeException e){
            log.error("Erro:",e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            log.error("Erro de servidor!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPlano(@PathVariable Long id, @RequestBody PlanoDTO planoDTO){
        try {
            PlanoDTO alterado = planoService.alterarPlano(id, planoDTO);
            log.info("plano alterado: {}",alterado);
            return ResponseEntity.status(HttpStatus.OK).body(alterado);
        } catch (RuntimeException e) {
            log.error("Erro: ",e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            log.error("Erro do servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlano(@PathVariable Long id){
        try {
            log.info("plano que vai ser deletado: {}", id);
            String deletar = planoService.deletarPlano(id);
            log.info("plano deletado: {}",deletar);
            return ResponseEntity.status(HttpStatus.OK).body(deletar);
        } catch (RuntimeException e) {
            log.error("Erro: ",e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            log.error("Erro do servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
