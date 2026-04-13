package Quixaba.dev.Gymsys.Controllers;

import Quixaba.dev.Gymsys.DTO.InstrutorDTO;
import Quixaba.dev.Gymsys.Services.InstrutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return ResponseEntity.status(HttpStatus.OK).body(instrutorDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
