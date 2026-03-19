package Quixaba.dev.Gymsys.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_plano")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlanoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoPlano tipoPlano;
    private BigDecimal preco;
    private Integer duracaoDias;

    @OneToMany(mappedBy = "plano")
    private List<ContratacaoModel> contratacoes;
}
