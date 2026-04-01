package Quixaba.dev.Gymsys.DTO;

import Quixaba.dev.Gymsys.Models.TipoPlano;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanoDTO {

    private Long id;
    private TipoPlano tipoPlano;
    private BigDecimal preco;
    private Integer duracaoDias;
    private Long idContrat;

}
