package Quixaba.dev.Gymsys.Repository;

import Quixaba.dev.Gymsys.Models.ContratacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContratacaoRepository extends JpaRepository<ContratacaoModel, Long> {
}
