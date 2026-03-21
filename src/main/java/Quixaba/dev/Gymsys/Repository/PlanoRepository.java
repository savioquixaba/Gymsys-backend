package Quixaba.dev.Gymsys.Repository;

import Quixaba.dev.Gymsys.Models.PlanoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<PlanoModel, Long> {
}
