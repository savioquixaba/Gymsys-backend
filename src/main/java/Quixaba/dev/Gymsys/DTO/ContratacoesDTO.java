package Quixaba.dev.Gymsys.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratacoesDTO {

    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private Long idAluno;
    private Long idPlano;
}
