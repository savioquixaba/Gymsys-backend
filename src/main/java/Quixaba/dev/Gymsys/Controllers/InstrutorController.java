package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.InstrutorDTO;
import Quixaba.dev.Gymsys.Services.InstrutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    private InstrutorService instrutorService;

    public InstrutorController(InstrutorService instrutorService){
        this.instrutorService = instrutorService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarInstrutor(@RequestBody InstrutorDTO instrutorDTO){
        try {
            InstrutorDTO criar = instrutorService.criarInstrutor(instrutorDTO);
            return ResponseEntity.status(HttpStatus.OK).body(criar);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<InstrutorDTO>> listar(){
        try {
            List<InstrutorDTO> lista = instrutorService.listarTodos();
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        } catch (RuntimeException e) {
            log.error("Não há dados a serem listados.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        try {
            InstrutorDTO listar = instrutorService.listarPorId(id);
            log.info("instrutor procurado: {}",listar);
            return ResponseEntity.status(HttpStatus.OK).body(listar);
        }catch (RuntimeException e) {
            log.error("Instrutor não encontrado",e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarInstrutor(@PathVariable Long id, InstrutorDTO instrutorDTO){
        try {
            InstrutorDTO alterado = instrutorService.alterarInstrutor(id,instrutorDTO);
            log.info("Id a ser alterado: {} ",id);
            return ResponseEntity.status(HttpStatus.OK).body(alterado);
        } catch (RuntimeException e) {
            log.error("ID NÃO ENCONTRADO");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        try {
            String deletado = instrutorService.deletePorId(id);
            log.info("Id a ser deletado: {} ",id);
            return ResponseEntity.status(HttpStatus.OK).body(deletado);
        } catch (RuntimeException e) {
            log.error("ID NÃO ENCONTRADO");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
