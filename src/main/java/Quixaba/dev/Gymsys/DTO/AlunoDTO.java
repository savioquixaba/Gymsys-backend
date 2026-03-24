package Quixaba.dev.Gymsys.DTO;

import Quixaba.dev.Gymsys.Models.TurmaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String matricula;
    private LocalDate dataNascimento;
    private TurmaDTO turma;
}
