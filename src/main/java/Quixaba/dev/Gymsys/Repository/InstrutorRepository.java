package Quixaba.dev.Gymsys.Repository;

import Quixaba.dev.Gymsys.Models.InstrutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InstrutorRepository extends JpaRepository<InstrutorModel, Long> {
}
