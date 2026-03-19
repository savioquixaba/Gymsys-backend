package Quixaba.dev.Gymsys.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_contratacao")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContratacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    @ManyToOne
    private AlunoModel aluno;

    @ManyToOne
    private PlanoModel plano;
}
