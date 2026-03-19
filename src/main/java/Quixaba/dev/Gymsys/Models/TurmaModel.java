package Quixaba.dev.Gymsys.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_turma")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurmaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    //Indica que Turma não é o lado dominante da relação
    @OneToMany(mappedBy = "turma")
    private List<AlunoModel>alunos;

    @ManyToOne
    private InstrutorModel instrutor;
}
