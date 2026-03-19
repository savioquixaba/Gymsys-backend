package Quixaba.dev.Gymsys.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "tb_aluno")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String matricula;
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "aluno")
    private List<ContratacaoModel>contratacoes;

    @ManyToOne
    private TurmaModel turma;
}
