package Quixaba.dev.Gymsys.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrutorDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String horario;

}
