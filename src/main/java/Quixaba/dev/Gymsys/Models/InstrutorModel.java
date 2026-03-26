package Quixaba.dev.Gymsys.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_instrutor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InstrutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String horario;

    @JsonIgnore
    @OneToMany(mappedBy = "instrutor")
    private List<TurmaModel> turmas;
}
