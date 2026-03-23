package Quixaba.dev.Gymsys.Repository;

import Quixaba.dev.Gymsys.Models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
}
