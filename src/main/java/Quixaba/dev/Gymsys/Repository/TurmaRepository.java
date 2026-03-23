package Quixaba.dev.Gymsys.Repository;

import Quixaba.dev.Gymsys.Models.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, Long> {
}
