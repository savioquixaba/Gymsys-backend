package Quixaba.dev.Gymsys.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    //Não permite espaços nem objetos nulos
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String matricula;

    @NotNull
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "aluno")
    private List<ContratacaoModel>contratacoes;

    @ManyToOne
    private TurmaModel turma;
}
